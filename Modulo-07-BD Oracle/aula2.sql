13/06/2017

Estatísticas:

Select * from user_tables;
EXEC dbms_stats.gather_schema_stats(USER);


-----------------------------------------------------
Begin
 DBMS_OUTPUT.PUT_LINE('Buenas tarde!');
End;

----------------  PL/SQL -------------------------------------

DECLARE
  vNome_Completo  varchar2(30);
  vAno            number(4);
  vData           date;
BEGIN
  -- Atribuindo um valor para a variavel
  vNome_Completo := 'Maria da Silva';
  vData          := sysdate+1000;
  vAno           := to_char(vData, 'yyyy');

    -- Imprimindo as variaveis 
  DBMS_OUTPUT.PUT_LINE(vNome_Completo);
  DBMS_OUTPUT.PUT_LINE('Em 1000 dias estaremos em: ' || to_char(vAno));
END;

-----------------------------------------------------

-- O INTO funciona apenas em consultas que retornam apenas UM registro, para exibir mais de uma linha
-- é preciso utilizar outra estrutura de dados ou um FOR-LOOP através de um cursor.
DECLARE
  vTotal   Integer;
BEGIN
  -- Consultando o total de registros
  Select count(1) 
  Into   vTotal
  From   Cliente;
  -- Imprimindo a variavel 
  DBMS_OUTPUT.PUT_LINE('Total: ' || to_char(vTotal));
END;

-----------------------------------------------------

DECLARE
  vTotal number(5);
BEGIN
  Select count(1) 
    into vTotal
    from Cliente;

  IF (vTotal = 0) THEN
    DBMS_OUTPUT.PUT_LINE('Nenhum registro foi encontrado!');
  ELSIF (vTotal = 1) THEN
    DBMS_OUTPUT.PUT_LINE('Um registro encontrado!');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Muitos clientes cadastrados!!!');
  END IF;
END;

-----------------------------------------------------

DECLARE
  vSituacao   Cliente.Situacao%type;
BEGIN
  Select Situacao
  into   vSituacao
  from   Cliente
  where  IDCliente = :p_IDCliente;

  CASE vSituacao 
    WHEN 'A' THEN DBMS_OUTPUT.PUT_LINE('Ativo!');
    WHEN 'I' THEN DBMS_OUTPUT.PUT_LINE('Inativo!');
    ELSE          DBMS_OUTPUT.PUT_LINE('Outro!');
  END CASE;
END;

----------------------------------------------------- 

DECLARE
  vContador number(2);
BEGIN
   vContador := 1;
   WHILE vContador <= 30 LOOP
     DBMS_OUTPUT.PUT_LINE('Executou: '|| to_char(vContador, '90'));
     vContador := vContador + 1;
   END LOOP;
END;

-----------------------------------------------------

BEGIN
   FOR vContador IN 1..30 LOOP
     DBMS_OUTPUT.PUT_LINE('Executou: '|| to_char(vContador, '90'));
   END LOOP;
END;

-----------------------------------------------------

DECLARE
  vNome Cliente.Nome%Type;
BEGIN
  Select Nome
  Into   vNome
  From   Cliente
  Where  IDCliente = :p_IDCliente;

  DBMS_OUTPUT.PUT_LINE('Nome: ' || vNome);

EXCEPTION
  When no_data_found Then 
    DBMS_OUTPUT.PUT_LINE('Cliente inexistente!');
END;

-----------------------------------------------------

DECLARE
 vNome Cliente.Nome%Type;
BEGIN
  Select Nome
  Into   vNome
  From   Cliente
  Where  IDCliente = :p_IDCliente;
  
  DBMS_OUTPUT.PUT_LINE('Nome: ' || vNome);

EXCEPTION
  When no_data_found Then 
    DBMS_OUTPUT.PUT_LINE('Cliente inexistente!');
 When too_many_rows Then 
    DBMS_OUTPUT.PUT_LINE('Existe mais de 1 registro!');
END;

-----------------------------------------------------

DECLARE
 vNome Cliente.Nome%Type;
BEGIN
  Select Nome
  Into   vNome
  From   Cliente
  Where  IDCliente = :p_IDCliente;
  
  DBMS_OUTPUT.PUT_LINE('Nome: ' || vNome);

EXCEPTION
  When no_data_found Then 
    DBMS_OUTPUT.PUT_LINE('Cliente inexistente!');
 When others Then 
    DBMS_OUTPUT.PUT_LINE('Erro Código=' || sqlerr);
END;