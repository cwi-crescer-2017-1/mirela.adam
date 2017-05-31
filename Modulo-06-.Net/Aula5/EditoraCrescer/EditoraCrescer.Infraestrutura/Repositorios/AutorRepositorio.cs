using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class AutorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
        }

        public void Excluir(int id)
        {
            var autor = contexto.Autores.FirstOrDefault(x => x.Id == id);
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }

        public List<Autor> ObterPorId(int id)
        {
            return contexto.Autores.Where(x => x.Id == id).ToList();
        }

        public List<Livro> ObterLivrosDoAutor(int id)
        {
            return contexto.Livros.Where(x => x.IdAutor == id).ToList();
        }

        public bool VerificaExistenciaAutor(int id)
        {
            return contexto.Autores.Count(x => x.Id == id) > 0;
        }

        public void Editar(Autor autor)
        {
            contexto.Entry(autor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        } 
    }
}
