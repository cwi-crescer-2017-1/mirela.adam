using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.Entity;

namespace Locadora.Infraestrutura.Repositorios
{
    public class LocacaoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public List<Locacao> Obter()
        {
            return contexto.Locacoes.Include(x => x.Cliente)
                                    .Include(x => x.Produto)
                                    .Include(x => x.Pacote)
                                    .Include(x => x.Opcionais)
                                    .ToList();
        }

        public void Criar(Locacao locacao)
        {
            contexto.Locacoes.Add(locacao);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

        public void Editar(Locacao locacao)
        {
            contexto.Entry(locacao).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
        }

        public List<Locacao> ObterLocacoesNaoDevolvidas()
        {
            return contexto.Locacoes
                            .Where(x => x.DataRealEntrega == null)
                            .Include(x => x.Cliente)
                            .Include(x => x.Produto)
                            .Include(x => x.Pacote)
                            .Include(x => x.Opcionais)
                            .ToList();
        }

        public Locacao ObterLocacaoPorId(int id)
        {
            return contexto.Locacoes.Where(x => x.Id == id).FirstOrDefault();
        }

    }
}
