using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class PacoteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Pacote> Obter()
        {
            return contexto.Pacotes.ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
