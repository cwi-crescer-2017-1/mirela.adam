--EXERCICIOS 
-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.
select p.idproduto, p.nome 
from produto p 
where p.idproduto not in (
  select pit.idproduto from pedidoitem pit 
  inner join pedido ped
  on ped.idpedido = pit.idpedido
  where ped.datapedido > add_months(trunc(sysdate), -4)
);

--Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses.

update produto prod
set prod.situacao = 'I'
where prod.idproduto not in (
  select pit.idproduto from pedidoitem pit 
  inner join pedido p
  on p.idpedido = pit.idpedido
  where p.datapedido > add_months(trunc(sysdate), -4)
);

--Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela 
-- PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2017).
select sum(pit.Quantidade) as quantidade
from pedidoitem pit
where pit.IdProduto = :IdProduto
and pit.IdProduto in (
  select pit.idproduto 
  from pedidoitem pite 
  inner join pedido p
  on p.idpedido = pite.idpedido
  where p.datapedido >= to_date('01/01/2017', 'DD/MM/YYYY')
)
group by pit.idproduto;
