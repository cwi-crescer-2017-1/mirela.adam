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
            var opcionalOriginal = locacao.Pacote.Opcionais;
            locacao.Pacote.Opcionais = null; //ideia da mirela

            contexto.Locacoes.Add(locacao);

            contexto.Entry(locacao.Cliente).State = EntityState.Unchanged;
            contexto.Entry(locacao.Produto).State = EntityState.Unchanged;
            contexto.Entry(locacao.Pacote).State = EntityState.Unchanged;
            
            //foreach (var opcional in locacao.Pacote.Opcionais)
            //{
            //    contexto.Entry(opcional).State = EntityState.Unchanged;
            //}

            foreach (var opcional in locacao.Opcionais)
            {
                contexto.Entry(opcional).State = EntityState.Unchanged;
            }

            contexto.SaveChanges();

            locacao.Pacote.Opcionais = opcionalOriginal;
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

        public object ObterLocacoesAtrasadas()
        {
            DateTime dataAtual = DateTime.UtcNow;
            return contexto.Locacoes
                            .Where(x => x.DataRealEntrega == null && x.DataPrevisaoEntrega < dataAtual)
                            .OrderBy(x => x.DataPrevisaoEntrega)
                            .Select(x => new {
                                Id = x.Id,
                                Cliente = x.Cliente,
                                Produto = x.Produto.Descricao,
                                Opcional = x.Opcionais,
                                ValorPrevisto = x.ValorPrevisao,
                                DataRetirada = x.DataRetirada,
                                DataPrevisaoEntrega = x.DataPrevisaoEntrega,
                                DiasAtraso = DbFunctions.DiffDays(x.DataPrevisaoEntrega, dataAtual)
                            }).ToList();
        }

        public object ObterLocacoesMensais(DateTime dataFiltro)
        {
            DateTime partirDe = dataFiltro.AddDays(-30);
            return contexto.Locacoes
                    .Where(x => x.DataRealEntrega != null && x.DataRealEntrega >= partirDe && x.DataRealEntrega <= dataFiltro)
                    .Include(x => x.Cliente)
                    .Include(x => x.Produto)
                    .Include(x => x.Pacote)
                    .Include(x => x.Opcionais)
                    .ToList();
        }

        public Locacao ObterLocacaoPorId(int id)
        {
            return contexto.Locacoes.Where(x => x.Id == id)
                .Include(x => x.Cliente)
                .Include(x => x.Produto)
                .Include(x => x.Pacote)
                .Include(x => x.Opcionais)
                .FirstOrDefault();
        }

    }
}
