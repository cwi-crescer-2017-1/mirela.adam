using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Locadora.Dominio.Entidades;
using Locadora.Infraestrutura.Repositorios;
using Locadora.Api.Models;
using Locadora.Api.App_Start;
using System.Threading;

namespace Locadora.Api.Controllers
{
    [AllowAnonymous]
    [RoutePrefix("api/acessos")]
    public class UsuarioController : ApiController
    {
        readonly UsuarioRepositorio _usuarioRepositorio;

        public UsuarioController()
        {
            _usuarioRepositorio = new UsuarioRepositorio();
        }

        [HttpGet, Route("usuario")]
        [BasicAuthorization]
        public IHttpActionResult Obter()
        {
            var usuarioDaSessao = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

            if (usuarioDaSessao == null)
            {
                return BadRequest("Usuario não encontrado");
            }
            var usuario = new { Email = usuarioDaSessao.Email, Permissoes = usuarioDaSessao.Permissoes };
            return Ok(new { dados = usuario });
        }
    }

}
