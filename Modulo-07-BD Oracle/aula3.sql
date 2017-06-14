Aula 3 - 14/06/2017
Criação de índice

create index IX_Cidade_NomeUF 
on Cidade(Nome,UF);

----

Procedures e Functions
COMMIT deve ser responsabilidade do processo principal que está executando a procedure.

Para chamar:
Exec Primeira_proc;

OU

BEGIN
  Primeira_proc;
END;
------------------------------------------
Exemplos

CREATE PROCEDURE PRIMEIRA_PROC AS
BEGIN
  DBMS_OUTPUT.PUT_LINE('Minha primeira PROCEDURE!!!');
END;

--

CREATE OR REPLACE
PROCEDURE INSERE_CIDADE( PNOME IN VARCHAR2,
                         PUF   IN VARCHAR2) AS
BEGIN

  Insert into Cidade (IDCidade, Nome, UF)
    values ( seq_cidade.nextval, initcap(pNome), pUF);

EXCEPTION
  When DUP_VAL_ON_INDEX Then
    Raise_Application_Error(-20001, 'Registro já cadastrado!');
END;


Exemplos de chamada da rotina criada:

Exec INSERE_CIDADE('Morro da Pedra', 'RS');
Exec INSERE_CIDADE(pNome=> 'Morro da Pedra', pUF=>'RS');

-------------------------------------------












