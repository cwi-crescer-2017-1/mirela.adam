/*Exercícios Lista 1*/

/* Crie a tabela CidadeAux a partir de uma cópia da tabela Cidade. Considere todos os registros existentes. */
select * 
into CidadeAux 
from cidade;

/* Limpe a tabela CidadeAux (Truncate table CidadeAux). E em seguida insira todas os registros da tabela Cidade
onde o estado seja RS. */
truncate table cidadeAux;
insert into cidadeAux select *  from cidade where UF = 'RS';

--outra solução
insert into cidadeAux(idcidade, uf, nome)
	select idcidade, uf, nome
	from cidade
	where uf='RS';

/* Crie uma tabela para armazenar informações de produtos. Devem ter os seguintes atributos:
Código de identificação; Nome curto, Nome descritivo, Data da criação, Local no estoque, Quantidade e Preço. */
create table Produto (
        IdProduto       int not null,
        NomeCurto       varchar(50) not null,
        NomeDescritivo  varchar(200) not null,
        DataCriacao     datetime not null,
        Localestoque    varchar(150) not null,
        Quantidade      numeric(10,2) not null,
        Preco           numeric(10,2) not null
    );

/* Crie dois registros nessa tabela nova (produto). */
begin transaction
insert into produto (idproduto, nomecurto, nomedescritivo, datacriacao, localestoque, quantidade, preco)
values (3, 'Kit Martelodasdsad', 'Kit Martelo - Conjunto com 3 - Cabo Borracha', '30-04-2017', 'Prateleira 2A', 14, 56.89); 
select * from produto;
rollback;
----------------------------


select convert(date, '12/05/2017' , 103);