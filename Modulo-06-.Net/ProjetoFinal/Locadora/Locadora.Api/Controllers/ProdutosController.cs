using Locadora.Api.App_Start;
using Locadora.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Locadora.Api.Controllers
{
    [BasicAuthorization]
    [RoutePrefix("api/Produtos")]
    public class ProdutosController : ApiController
    {
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();

        //GET api/Produtos
        [HttpGet]
        public IHttpActionResult ObterProdutos()
        {
            var produtos = repositorio.Obter();
            return Ok(new { dados = produtos });
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
