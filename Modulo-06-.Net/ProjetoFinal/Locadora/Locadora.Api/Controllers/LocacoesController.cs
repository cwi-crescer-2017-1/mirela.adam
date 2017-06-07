using Locadora.Api.Models;
using Locadora.Infraestrutura.Repositorios;
using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Locadora.Api.Controllers
{
    [RoutePrefix("api/Locacoes")]
    public class LocacoesController : ApiController
    {
        private LocacaoRepositorio repositorioLocacao = new LocacaoRepositorio();
        private ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        private ProdutoRepositorio repositorioProduto = new ProdutoRepositorio();
        private PacoteRepositorio repositorioPacote = new PacoteRepositorio();
        private OpcionalRepositorio repositorioOpcionais = new OpcionalRepositorio();

        //GET api/Locacoes
        [HttpGet]
        public IHttpActionResult ObterLocacoes()
        {
            var locacoes = repositorioLocacao.Obter();
            return Ok(new { dados = locacoes });
        }

        //GET api/Locacoes
        [HttpGet]
        [Route("devolucoes")]
        public IHttpActionResult ObterLocacoesNaoDevolvidas()
        {
            var locacoesNaoDevolvidas = repositorioLocacao.ObterLocacoesNaoDevolvidas();
            return Ok(new { dados = locacoesNaoDevolvidas });
        }

        //POST api/Locacoes 
        [HttpPost]
        public IHttpActionResult IncluirLocacao(LocacaoModel locacaoModel)
        {
            var cliente = repositorioCliente.ObterClientePorId(locacaoModel.IdCliente);
            var produto = repositorioProduto.ObterProdutoPorId(locacaoModel.IdProduto);
            var pacote = repositorioPacote.ObterPacotePorId(locacaoModel.IdPacote);
            var opcionais = repositorioOpcionais.ObterOpcionaisPorId(locacaoModel.IdsOpcionais);

            var locacao = new Locacao(cliente, produto, pacote, opcionais);
            repositorioLocacao.Criar(locacao);
            return Ok(locacao);
        }

        [HttpPut]
        public IHttpActionResult DevolverLocacao(int id)
        {
            var locacao = repositorioLocacao.ObterLocacaoPorId(id);

            locacao.Devolver();

            repositorioLocacao.Editar(locacao);
            return Ok(locacao);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorioLocacao.Dispose();

            base.Dispose(disposing);
        }
    }
}
