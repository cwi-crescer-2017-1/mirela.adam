create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdar� as propriedades do campo percentual
      begin

        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribu� valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);

        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme defin��o das regras */
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
     Quest�o "A" - implementar rotina que ir� inserir um novo concurso
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
     Quest�o "B" - implementar rotina que ir� inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
   begin
      null; --> codar aqui
   end atualizaAcertadores;

begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;