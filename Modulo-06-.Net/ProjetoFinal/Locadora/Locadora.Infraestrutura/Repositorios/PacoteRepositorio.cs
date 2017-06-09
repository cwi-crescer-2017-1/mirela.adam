using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.Entity;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class PacoteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Pacote> Obter()
        {
            return contexto.Pacotes
                .Include(x => x.Opcionais)
                .ToList();
        }

        public Pacote ObterPacotePorId(int id)
        {
            return contexto.Pacotes.Where(x => x.Id == id).FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
