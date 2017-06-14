/*
Cidades Duplicadas
Atualmente a tabela de Cidade tem registros duplicados (nome e UF). 
Faça um código (PL/SQL) que liste quais são as cidades duplicadas. 
Após isso liste todos os clientes que estão relacionados com estas cidades
*/
 DECLARE
 CURSOR C_CidadesDuplicadas IS
     Select Nome, 
            UF
     From   Cidade
     group by nome, uf
     having count(1) > 1;
     
  CURSOR C_ClientesRelacionados(pNomeCidade in varchar2, pUF in varchar2) IS
  select cli.nome
    from cliente cli
      inner join cidade cid on cli.idcidade = cid.idcidade
    where cid.nome  = pNomeCidade
    and cid.UF = pUF;
  
BEGIN
   FOR cidade IN C_CidadesDuplicadas LOOP
        DBMS_OUTPUT.PUT_LINE( 'Cidade: ' || cidade.Nome || ' - UF: ' || cidade.UF);
     FOR cliente IN C_ClientesRelacionados(cidade.Nome, cidade.UF) LOOP
        DBMS_OUTPUT.PUT_LINE( 'Cliente: ' || cliente.Nome);
     END LOOP;
   END LOOP;
END;
    
-------------------------------------------------------------------------------------------

/*
Atualizando Valor do Pedido
Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens. 
Esta rotina deve receber por parametro o IDPedido e então verificar o valor total de seus itens (quantidade x valor unitário).
*/
select * from pedido order by idpedido;
DECLARE
  vCodigo pedido.idpedido%type;
begin
 -- vCodigo := 43;
  
  update pedido 
  set valorpedido = (
          select sum(item.quantidade * item.precounitario)
          from pedidoitem item
            inner join pedido p on item.idpedido = p.idpedido
          where p.idpedido = :vCodigo) 
  where idpedido = :vCodigo;
end;
