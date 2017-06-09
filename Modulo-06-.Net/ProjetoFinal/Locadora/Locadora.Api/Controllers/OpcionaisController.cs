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
    [RoutePrefix("api/Opcionais")]
    public class OpcionaisController : ApiController
    {
        private OpcionalRepositorio repositorio = new OpcionalRepositorio();

        //GET api/Opcionais
        [HttpGet]
        public IHttpActionResult ObterOpcionais()
        {
            var opcionais = repositorio.Obter();
            return Ok(new { dados = opcionais });
        }


        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
