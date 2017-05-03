/* 1
Primeiro nome
Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
Exemplo de resultado esperado:
PrimeiroNome	TotalOcorrencias
  Juvenita	        7
*/

select substring(nome, 1, charindex(' ', nome, 1) - 1) as PrimeiroNome, count(*) as TotalOcorrencias
from cliente
group by substring(nome, 1, charindex(' ', nome, 1) - 1)
order by primeironome;

/* 2 
Total do M�s
Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017.
Exemplo de resultado esperado:
Quantidade	ValorPedido
   469	   22,817,022.06
*/

select count(idPedido) as Quantidade, sum(valorPedido) as ValorPedido
from pedido
where datapedido between CONVERT(date, '01/04/2017', 103)    
                     and CONVERT(date, '30/04/2017', 103);

/* 3
Estados x Clientes
Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), 
liste tamb�m qual o Estado possu� o menor n�mero de clientes.
Exemplo de resultado esperado:
UF	TotalClientes
AC	24
MG	2008
*/

select cid.uf as UF,count(cli.idCliente) as TotalClientes
from cidade cid
	inner join cliente cli 
	on cid.IDCidade = cli.IDCidade 
where 
	cid.uf = (	select top 1 ci.uf
				from cidade ci
					inner join cliente cl
					on ci.IDCidade = cl.IDCidade
				group by ci.uf
				order by count(cl.IDCliente)
			 )
	or 
	cid.uf = (	
				select top 1 ci.uf
				from cidade ci
					inner join cliente cl
					on ci.IDCidade = cl.IDCidade
				group by ci.uf
				order by count(cl.IDCliente) desc
			 )
group by cid.uf;

/* 4
Novo Produto
Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
Nome: Galocha Maragato
Pre�o de custo: 35.67
Pre�o de venda: 77.95
Situa��o: A
*/
insert into produto (nome, datacadastro, precocusto, precovenda, situacao)
values ('Galocha Maragato', convert(date, getDate(), 103), 35.67, 77.95, 'A');

/* 5
Produtos n�o comprados
Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados,
pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
=> Obs.: o produto criado anteriormente dever� ser listado (apenas este)
*/
select p.nome
from produto p
	left join pedidoitem pit
	on p.IDProduto = pit.IDProduto
where pit.IDPedido is null;

/*
Principais Produtos
Liste os 30 produtos que mais geraram lucro em 2016.
*/

select top 30 p.nome, sum(pit.PrecoUnitario * pit.Quantidade)-sum(pit.quantidade*P.PrecoCusto)
from produto p
	inner join pedidoitem pit
	on p.IDProduto = pit.IDPedido
	inner join pedido ped
	on pit.IDPedido = ped.IDPedido
where year(ped.datapedido) = 2016
group by p.IDProduto, p.nome
order by sum(pit.PrecoUnitario * pit.Quantidade)-sum(pit.quantidade*P.PrecoCusto) desc;
