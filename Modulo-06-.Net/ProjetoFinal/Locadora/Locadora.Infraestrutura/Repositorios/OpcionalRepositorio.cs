using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Repositorios
{
    public class OpcionalRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Opcional> Obter()
        {
            return contexto.Opcionais.ToList();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
