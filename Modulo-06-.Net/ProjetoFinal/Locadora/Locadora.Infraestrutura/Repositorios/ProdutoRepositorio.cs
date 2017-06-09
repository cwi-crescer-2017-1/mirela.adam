using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Produto> Obter()
        {
            return contexto.Produtos.ToList();
        }

        public Produto ObterProdutoPorId(int id)
        {
            return contexto.Produtos.Where(x => x.Id == id).FirstOrDefault();
        }

        public void DiminuirEstoque(int id)
        {
            var produto = contexto.Produtos.Where(x => x.Id == id).FirstOrDefault();
            --produto.QtdEstoque;
            contexto.SaveChanges();
            return;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public void AumentarEstoque(int id)
        {
            var produto = contexto.Produtos.Where(x => x.Id == id).FirstOrDefault();
            ++produto.QtdEstoque;
            contexto.SaveChanges();
            return;
        }
    }
}
