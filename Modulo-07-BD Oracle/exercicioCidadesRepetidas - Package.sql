create or replace package pck_EliminaCidadesDuplicadas as
  procedure Busca_Cidades_Duplicadas;
  function BuscaIDMinimo(pNome varchar2, pUF varchar2) return Cidade.IDCidade%type;
end pck_EliminaCidadesDuplicadas;

-----

create or replace package body pck_EliminaCidadesDuplicadas as

PROCEDURE Busca_Cidades_Duplicadas AS
  CURSOR C_CidadesDuplicadas IS
     Select Nome,
            UF
     From   Cidade
     group by nome, uf
     having count(1) > 1;

 CURSOR C_ClientesRelacionados(pNomeCidade in varchar2, pUF in varchar2) IS
    select  cli.IDCliente
     from   Cliente cli
      inner join Cidade cid on cid.IDCidade = cli.IDCidade
     where  cid.Nome = pNomeCidade
     and    cid.UF   = pUF;

 vIdMinimo Cidade.IDCidade%type;

BEGIN
   FOR c IN C_CidadesDuplicadas LOOP

    vIdMinimo := BuscaIDMinimo(c.nome, c.uf);

    FOR cli IN C_ClientesRelacionados(c.Nome, c.UF) LOOP
           update cliente
           set idcidade = vIdMinimo
           where idcliente = cli.idcliente
           and idcidade != vIdMinimo;
     END LOOP;

          delete from cidade
           where nome = c.nome
           and uf = c.uf
           and idcidade != vIdMinimo;

   END LOOP;
END;
---------------------
function BuscaIDMinimo(pNome in varchar2, pUF in varchar2) return Cidade.IDCidade%type as
  vIDMinimo Cidade.IDCidade%type;
begin
  select min(idCidade)
  into vIDMinimo
  from cidade
  where nome = pNome and uf=pUF;

 return vIDMinimo;
end BuscaIDMinimo;
end;