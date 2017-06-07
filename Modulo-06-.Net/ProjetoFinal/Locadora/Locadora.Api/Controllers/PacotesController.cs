﻿using Locadora.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Locadora.Api.Controllers
{
    [RoutePrefix("api/Pacotes")]
    public class PacotesController : ApiController
    {
        private PacoteRepositorio repositorio = new PacoteRepositorio();

        //GET api/Clientes
        [HttpGet]
        public IHttpActionResult ObterPacotes()
        {
            var pacotes = repositorio.Obter();
            return Ok(new { dados = pacotes });
        }
    }
}
