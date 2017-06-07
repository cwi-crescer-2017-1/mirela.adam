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

        public List<Opcional> ObterOpcionaisPorId(List<int> listaOpcionais)
        {
            List<Opcional> retorno = null;
            foreach (var id in listaOpcionais)
            {
                var opcional = ObterPorId(id);
                retorno.Add(opcional);
            }
            return retorno;
        }

        public Opcional ObterPorId(int id)
        {
            return contexto.Opcionais.Where(x => x.Id == id).FirstOrDefault();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}
