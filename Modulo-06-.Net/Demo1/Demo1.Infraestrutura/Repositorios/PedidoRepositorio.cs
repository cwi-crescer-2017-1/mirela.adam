using Demo1.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao =
                         @"Server=13.65.101.67;
                        User Id=mirela.adam;
                        Password=123456;
                        Database=aluno06db";

        public void Alterar(Pedido pedido)
        {
            throw new NotImplementedException();
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                // Executa o INSERT
                using (var comandoInsertPedido = conexao.CreateCommand())
                {
                    comandoInsertPedido.CommandText =
                        @"INSERT INTO Pedido (NomeCliente) 
                        VALUES (@nomecliente)";

                    comandoInsertPedido.Parameters.AddWithValue("@nomecliente", pedido.NomeCliente);
                    comandoInsertPedido.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = "SELECT @@IDENTITY";

                    // Executa o comando e retorna o primeiro resultado
                    var result = (decimal)comando.ExecuteScalar();
                    pedido.Id = (int)result;
                }

                foreach (var item in pedido.Itens)
                {
                    using (var comandoInsertItemPedido = conexao.CreateCommand())
                    {
                        comandoInsertItemPedido.CommandText =
                            @"INSERT INTO ItemPedido (PedidoId, ProdutoId, Quantidade)
                                  VALUES (@pedidoid, @produtoid, @quantidade)";
                        comandoInsertItemPedido.Parameters.AddWithValue("@pedidoid", pedido.Id);
                        comandoInsertItemPedido.Parameters.AddWithValue("@produtoid", item.ProdutoId);
                        comandoInsertItemPedido.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comandoInsertItemPedido.ExecuteNonQuery();

                        comandoInsertItemPedido.CommandText = 
                            @"UPDATE Produto SET Estoque -= @quantidade WHERE Id = @produtoId";

                        comandoInsertItemPedido.Parameters.AddWithValue("@itemProdutoId", item.ProdutoId);
                        comandoInsertItemPedido.ExecuteNonQuery();
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT p.Id, p.NomeCliente
                          FROM Pedido p";

                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();

                        pedido.Id = (int)dataReader["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        
                        pedidos.Add(pedido);
                    }
                }
            }

            return pedidos;
        }

        public Pedido Obter(int id)
        {
            throw new NotImplementedException();
        }
    }
}
