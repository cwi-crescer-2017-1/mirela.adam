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
        
        public object Obter()
        {
            /*
            return contexto.Livros
                                .Include(x => x.Autor)
                                .Include(x => x.Revisor)
                                .ToList();
                                */
            return contexto.Livros
                            .Select(x => new
                            {
                                Isbn = x.Isbn,
                                Titulo = x.Titulo,
                                NomeAutor = x.Autor.Nome,
                                Genero = x.Genero,
                                Capa = x.Capa
                            }).ToList();
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

        public object ObterPorGenero(string genero)
        {
            return contexto.Livros.Where(x => x.Genero.Contains(genero)).Select(x => new
            {
                Isbn = x.Isbn,
                Titulo = x.Titulo,
                NomeAutor = x.Autor.Nome,
                Genero = x.Genero,
                Capa = x.Capa
            }).ToList(); ;
                
        }

        public object ObterLivrosPublicadosExcetoLancamentos(int quantidadePular, int quantidadeTrazer)
        {
            throw new NotImplementedException();
        }

        public object ObterLancamentos()
        {
            var dataDoFiltro = DateTime.Now.Date.AddDays(-7);

            return contexto.Livros
                       .Where(x => x.DataPublicacao >= dataDoFiltro)
                                   .Select(x => new
                                   {
                                       Isbn = x.Isbn,
                                       Titulo = x.Titulo,
                                       NomeAutor = x.Autor.Nome,
                                       Genero = x.Genero,
                                       Capa = x.Capa
                                   }).ToList();
        }

        public void Editar(Livro livro)
        {
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public bool VerificaExistenciaLivro(int isbn)
        {
            return contexto.Livros.Count(x => x.Isbn == isbn) > 0;
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
