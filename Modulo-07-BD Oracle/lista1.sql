--EXERCICIOS 
-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.
create view vwProdutos_Sem_Compra as
select p.idproduto, p.nome 
from produto p 
where p.idproduto not in (
  select pit.idproduto from pedidoitem pit 
  inner join pedido ped on ped.idpedido = pit.idpedido
  where ped.datapedido >= add_months(trunc(sysdate), -4)
);
--Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses.
update produto
set situacao = 'I'
where idproduto in (select IDProduto from vwProdutos_Sem_Compra)
and situacao='A';
--ou
update produto 
set dituacao = 'I'
where exists (select IdProduto from vwProdutos_Sem_compra vw where Produto.IdProduto = vw.IdProduto) and Situacao = 'A';
--Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela 
-- PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2017).
select sum(item.Quantidade) as quantidade
from pedidoitem item
  inner join pedido ped on ped.IDPedido = item.IDPedido
where item.IdProduto = :p_IdProduto
and ped.DataPedido >= trunc(sysdate, 'yyyy');