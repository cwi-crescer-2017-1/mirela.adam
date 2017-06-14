/* exercício 3
Atualização de Clientes
Crie uma rotina que atualize todos os clientes que não realizaram nenhum pedido nos últimos 6 meses 
(considere apenas o mês, dia 01 do 6º mês anterior). Definir o atributo Situacao para I.
*/

DECLARE
  CURSOR C_ClientesSemPedido IS
    select c.idcliente, c.nome
    from cliente c 
    where c.idcliente not in (
                            select distinct p.idcliente 
                            from pedido p 
                            where p.datapedido >= add_months(trunc(sysdate, 'MM'), -6))
    order by c.idcliente;
BEGIN
  FOR cliente IN C_ClientesSemPedido LOOP
    UPDATE CLIENTE
    SET SITUACAO = 'I'
    WHERE IDCliente = cliente.idcliente;
  END LOOP;
END;

--------------------------------------

/*
Previsão de Materiais
Faça uma rotina que receba dois parâmetros:
IDProduto
Mês e Ano
E então faça uma rotina que verifique no ANO/MÊS para o produto informado qual a lista de materiais 
(incluindo a quantidade) é necessário para atender todos os Pedidos desde período. 
Deve imprimir o nome do material e quantidade total.
*/