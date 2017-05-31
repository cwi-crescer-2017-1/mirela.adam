using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraestrutura.Repositorios
{
    public class RevisorRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void Criar(Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void Excluir(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(x => x.Id == id);
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }

        public List<Revisor> ObterRevisorPorId(int id)
        {
            return contexto.Revisores.Where(x => x.Id == id).ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public bool VerificaExistenciaRevisor(int id)
        {
            return contexto.Revisores.Count(x => x.Id == id) > 0;
        }

        public void Editar(Revisor revisor)
        {
            contexto.Entry(revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }
    }
}
