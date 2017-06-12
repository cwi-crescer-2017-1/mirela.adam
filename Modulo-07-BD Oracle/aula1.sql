--criacao tabela
CREATE TABLE PESSOA (
  IDPessoa  integer not null,
  Nome      varchar2(30) not null,
  constraint PK_Pessoa primary key (IDPessoa)
);
-- sequence
create sequence SQPessoa;
-- popular tabela usando sequence
insert into pessoa (idpessoa, nome)
values (SQPessoa.nextval, 'Mirela Haag Adam');
--select 
select * from pessoa;
-- Comandos DDL fazem o commit automaticamente


-- consulta com parametro
select IDProduto, Nome
from Produto
where lower(Nome) like :Nome;