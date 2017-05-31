using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class LivroRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();
        
        public List<Livro> Obter()
        {
            return contexto.Livros.ToList();
        }

        public void Criar(Livro livro)
        {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
        }

        public void Excluir(int isbn)
        {
            var livro = contexto.Livros.FirstOrDefault(x => x.Isbn == isbn);
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }

        public List<Livro> ObterPorIsbn(int isbn)
        {
            return contexto.Livros.Where(x => x.Isbn == isbn).ToList();
        }

        public List<Livro> ObterPorGenero(string genero)
        {
            return contexto.Livros.Where(x => x.Genero == genero).ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public void Editar(Livro livro)
        {
            var original = contexto.Livros.Find(livro.Isbn);
            contexto.Entry(original).CurrentValues.SetValues(livro);
            contexto.SaveChanges();
        }

        public bool VerificaExistenciaLivro(int isbn)
        {
            return contexto.Livros.Count(x => x.Isbn == isbn) > 0;
        }
    }
}
