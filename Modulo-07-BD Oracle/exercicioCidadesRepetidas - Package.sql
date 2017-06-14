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
   FOR cidade IN C_CidadesDuplicadas LOOP

    vIdMinimo := BuscaIDMinimo(cidade.nome, cidade.uf);

    FOR cliente IN C_ClientesRelacionados(cidade.Nome, cidade.UF) LOOP
           update cliente
           set idcidade = vIdMinimo
           where idcliente = cliente.idcliente
           and idcidade != vIdMinimo;
           print('linhas alterados: '|| sql%rowcount );
           dbms_output.put_line(to_char(cliente.idcliente) || '-' || to_char(vIdMinimo) || '-' || cidade.nome);
     END LOOP;

          delete from cidade
           where nome = cidade.nome
           and uf = cidade.uf
           and idcidade != vIdMinimo;

          print('linhas excluidas: '|| sql%rowcount );
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