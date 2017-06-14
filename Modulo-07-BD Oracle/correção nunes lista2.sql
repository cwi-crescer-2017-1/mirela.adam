--exercicio 1

declare
  cursor c_cidades is
       select Nome, UF
       from   Cidade
       group  by Nome, UF
       having count(1) >1;

  cursor c_clientes (pNome in varchar2,
                     pUF   in varchar2) is
     select cli.IDCliente,
            cli.Nome as Nome_Cliente,
            cid.Nome as Nome_Cidade,
            cid.UF
     from   Cliente cli
      inner join Cidade cid on cid.IDCidade = cli.IDCidade
     where  cid.Nome = pNome
     and    cid.UF   = pUF;
begin

  FOR c in c_cidades LOOP     
      dbms_output.put_line('Cidade: '|| c.Nome );
      FOR i in c_clientes (c.Nome, c.UF) LOOP
           dbms_output.put_line('Cliente: '|| i.Nome_Cliente );
      END LOOP;
  END LOOP;

end;

-- índices para melhorar o desempenho (execute apenas 1 vez)
create index IX_Cidade_NomeUF   on Cidade (Nome,UF);
create index IX_Cliente_Cidade  on Cliente (IDCidade);


--exercicio dois
CREATE OR REPLACE
PROCEDURE Atualiza_Valor_Pedido (pIDPedido IN INTEGER) AS
  vValorPedido  Pedido.ValorPedido%type;
BEGIN

   Select SUM(Quantidade * PrecoUnitario)
   into   vValorPedido
   From   PedidoItem
   Where  IDPedido = pIDPedido;
   
   Update Pedido
   Set    ValorPedido = vValorPedido
   Where  IDPedido    = pIDPedido;

END;