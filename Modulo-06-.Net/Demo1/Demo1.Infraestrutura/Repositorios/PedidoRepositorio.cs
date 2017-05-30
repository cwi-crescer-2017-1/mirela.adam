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
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comandoUpdatePedido = conexao.CreateCommand())
                {
                    comandoUpdatePedido.CommandText =
                        @"UPDATE Pedido
                          SET NomeCliente = @nomecliente
                          WHERE Id = @pedidoId";

                    comandoUpdatePedido.Parameters.AddWithValue("@nomecliente", pedido.NomeCliente);
                    comandoUpdatePedido.Parameters.AddWithValue("@pedidoId", pedido.Id);
                    comandoUpdatePedido.ExecuteNonQuery();
                }


                foreach (var item in pedido.Itens)
                {
                    using (var comandoUpdateItemPedido = conexao.CreateCommand())
                    {
                        comandoUpdateItemPedido.CommandText =
                            @"UPDATE ItemPedido
                              SET  ProdutoId = @produtoid, 
                                   Quantidade = @quantidade
                              WHERE PedidoId = @pedidoid";
                        comandoUpdateItemPedido.Parameters.AddWithValue("@pedidoid", pedido.Id);
                        comandoUpdateItemPedido.Parameters.AddWithValue("@produtoid", item.ProdutoId);
                        comandoUpdateItemPedido.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comandoUpdateItemPedido.ExecuteNonQuery();
                    }

                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText =
                          @"UPDATE Produto SET Estoque -= @quantidade WHERE Id = @produtoId";

                        comando.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comando.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comando.ExecuteNonQuery();
                    }                    
                }
            }
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
                    }

                    using (var comandoUpdate = conexao.CreateCommand())
                    {
                        comandoUpdate.CommandText =
                           @"UPDATE Produto SET Estoque -= @quantidade WHERE Id = @produtoId";
                        comandoUpdate.Parameters.AddWithValue("@produtoId", item.ProdutoId);
                        comandoUpdate.Parameters.AddWithValue("@quantidade", item.Quantidade);
                        comandoUpdate.ExecuteNonQuery();
                    }
                }
            }
        }

        public void Excluir(int id)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"DELETE FROM ItemPedido
                          WHERE PedidoId = @pedidoId";
                    comando.Parameters.AddWithValue("@pedidoId", id);
                    comando.ExecuteNonQuery();
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"DELETE FROM Pedido
                          WHERE Id = @pedidoId";
                    comando.Parameters.AddWithValue("@pedidoId", id);
                    comando.ExecuteNonQuery();
                }
            }
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
                        @"SELECT Id, NomeCliente FROM Pedido";

                    using (var dataReader = comando.ExecuteReader())
                    {
                        while (dataReader.Read())
                        {
                            var pedido = new Pedido();

                            pedido.Id = (int)dataReader["Id"];
                            pedido.NomeCliente = (string)dataReader["NomeCliente"];

                            pedidos.Add(pedido);
                        }
                    }
                }

                foreach (var pedido in pedidos)
                {
                    using (var comando = conexao.CreateCommand())
                    {
                        comando.CommandText = @"SELECT id, PedidoId, Quantidade FROM ItemPedido WHERE PedidoId = @pedidoId";
                        comando.Parameters.AddWithValue("@pedidoId", pedido.Id);
                        using (var dataReader = comando.ExecuteReader())
                        {
                            while (dataReader.Read())
                            {
                                ItemPedido itempedido = new ItemPedido();
                                itempedido.Id = (int)dataReader["id"];
                                itempedido.ProdutoId = (int)dataReader["PedidoId"];
                                itempedido.Quantidade = (int)dataReader["Quantidade"];
                                pedido.Itens.Add(itempedido);
                            }
                        }
                    }
                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            var pedido = new Pedido();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText =
                        @"SELECT Id, NomeCliente
                          FROM Pedido
                          WHERE Id = @idPedido";

                    comando.Parameters.AddWithValue("@idPedido", id);

                    using (var dataReader = comando.ExecuteReader())
                    {
                        while (dataReader.Read())
                        {
                            pedido.Id = (int)dataReader["Id"];
                            pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        }
                    }
                }

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT id, PedidoId, Quantidade FROM ItemPedido WHERE PedidoId = @pedidoId";
                    comando.Parameters.AddWithValue("@pedidoId", pedido.Id);

                    using (var dataReader = comando.ExecuteReader())
                    {
                        while (dataReader.Read())
                        {
                            ItemPedido itempedido = new ItemPedido();
                            itempedido.Id = (int)dataReader["id"];
                            itempedido.ProdutoId = (int)dataReader["PedidoId"];
                            itempedido.Quantidade = (int)dataReader["Quantidade"];
                            pedido.Itens.Add(itempedido);
                        }
                    }
                }
                        
            }

            return pedido;
        }
    }
}
