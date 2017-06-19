create or replace package pck_megasena is

  -- Author  : ANDRENUNES
  -- Purpose : Manipulação na base de dados da Loteria mais conhecida do Brasil
  
  -- Variáveis Globais - definidas em procedimento específico
  gPremio_sena          number(12,2) := 0;
  gPremio_quina         number(12,2) := 0;
  gPremio_quadra        number(12,2) := 0;
  gAcumulado_proximo_05 number(12,2) := 0;
  gAcumulado_final_ano  number(12,2) := 0;

  -- Public type declarations
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number);
  procedure geraProximoConcurso;
  function buscaPercentual(pIdentificador in varchar2) return number;
  procedure atualizaAcertadores (pConcurso in integer);

end pck_megasena;

----------------------------------------------------

create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin

        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);

        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin

       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;

    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);

       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );

       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */

  procedure geraProximoConcurso as
   vUltimoIdConcurso CONCURSO.IDCONCURSO%type;
   vValorArrecadado APOSTA.VALOR%type;
   vPremioBruto  CONCURSO.PREMIO_SENA%type;
   vConcursoAcumulou CONCURSO.ACUMULOU%type;
   vPremioSena CONCURSO.PREMIO_SENA%type;

   begin
    --busca ultimo id  
    select max(idconcurso) into vUltimoIdConcurso from concurso;

    --busca valor arrecadado no ultimo concurso
    select sum(valor) into vValorArrecadado from aposta where idconcurso = vUltimoIdConcurso;

    --define o valor do premio bruto
    vPremioBruto := vValorArrecadado * 0.453;

    --verifica se ultimo concurso acumulou, se sim, soma o valor da sena com o valor do premio bruto
    select ACUMULOU into vConcursoAcumulou from CONCURSO where IDCONCURSO = vUltimoIdConcurso;

    if(vConcursoAcumulou = 1) then
      select PREMIO_SENA into vPremioSena from CONCURSO where IDCONCURSO = vUltimoIdConcurso;
      vPremioBruto := vPremioBruto + vPremioSena;
    end if;

    -- salva o concurso
    salvaConcurso(vUltimoIdConcurso + 1, trunc(sysdate), vPremioBruto);

   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
    cursor c_apostasVencedoras is 
    select *
    from (select a.idaposta, count(case when 
                       na.numero = c.primeira_dezena or 
                       na.numero = c.segunda_dezena or
                       na.numero = c.terceira_dezena or
                       na.numero = c.quarta_dezena or
                       na.numero = c.quinta_dezena or
                       na.numero = c.sexta_dezena
                     then 1 end) as qtdAcertos
    from aposta a
        join concurso c on c.idconcurso = a.idconcurso
        join numero_aposta na on na.idaposta = a.idaposta
    where c.idconcurso = pConcurso
    group by a.idaposta)
    where qtdAcertos >= 4;
        
    vAcumulou integer;        
    vGanhadoresSena integer := 0;
    vGanhadoresQuina integer := 0;
    vGanhadoresQuadra integer := 0;
    vPremioSena concurso.premio_sena%type;
    vPremioQuina concurso.premio_quina%type;
    vPremioQuadra concurso.premio_quadra%type;
        
    vPremioGanhador aposta_premiada.valor%type;
    vUltimoID integer;
    
    begin
    vAcumulou := 1;
    FOR aposta IN C_ApostasVencedoras LOOP
        IF (aposta.qtdAcertos = 6) THEN
          vAcumulou := 0;
          vGanhadoresSena := vGanhadoresSena + 1;
        ELSIF (aposta.qtdAcertos = 5) THEN
          vGanhadoresQuina := vGanhadoresQuina + 1;
        ELSIF (aposta.qtdAcertos = 4) THEN
          vGanhadoresQuadra := vGanhadoresQuadra + 1;
        END IF;
      END LOOP;
        
      IF vAcumulou = 1 THEN
        update concurso set acumulou = 1 where idconcurso = pConcurso;
      END IF;
        
    select (Premio_Quadra / case when vGanhadoresQuadra = 0 then 1 when vGanhadoresQuadra <> 0 then vGanhadoresQuadra end) 
        into vPremioQuadra from Concurso where IDConcurso = pConcurso;
    select (Premio_Quina / case when vGanhadoresQuina = 0 then 1 when vGanhadoresQuina <> 0 then vGanhadoresQuina end) 
        into vPremioQuina from Concurso where IDConcurso = pConcurso;
    select (Premio_Sena / case when vGanhadoresSena = 0 then 1 when vGanhadoresSena <> 0 then vGanhadoresSena end) 
        into vPremioSena from Concurso where IDConcurso = pConcurso;
      
    select coalesce(max(IDAposta_Premiada), 0) 
        into vUltimoID from Aposta_Premiada;
      
    FOR aposta IN C_ApostasVencedoras LOOP
        IF (aposta.qtdAcertos = 6) THEN
            vPremioGanhador := vPremioSena;
        ELSIF (aposta.qtdAcertos = 5) THEN
            vPremioGanhador := vPremioQuina;
        ELSIF (aposta.qtdAcertos = 4) THEN
            vPremioGanhador := vPremioQuadra;
        END IF;
        vUltimoID := vUltimoID + 1;
        insert into aposta_premiada (idaposta_premiada, idaposta, acertos, valor)
        values (vUltimoID, aposta.idaposta, aposta.qtdAcertos, vPremioGanhador);
      END LOOP;
        
 end atualizaAcertadores;
 
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;