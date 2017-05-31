using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/Revisores")]
    public class RevisoresController : ApiController
    {
        private RevisorRepositorio repositorio = new RevisorRepositorio();

        //GET    api/Revisores
        [HttpGet]
        public IHttpActionResult ObterRevisores()
        {
            var revisores = repositorio.Obter();
            return Ok(revisores);
        }

        //GET    api/Revisores/{id}
        [HttpGet]
        public IHttpActionResult ObterRevisorPorId(int id)
        {
            var revisor = repositorio.ObterRevisorPorId(id);
            return Ok(new { dados = revisor });
        }
        
        //POST   api/Revisores
        [HttpPost]
        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok(revisor);
        }

        //DELETE api/Revisores/{id}
        [HttpDelete]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }

        //PUT    api/Revisores/{id}
        [HttpPut]
        public HttpResponseMessage EditarRevisor(int id, Revisor revisor)
        {
            var mensagens = new List<string>();
            if (id != revisor.Id)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - Id's diferentes" } });

            if (!repositorio.VerificaExistenciaRevisor(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - Revisor não cadastrado" } });

            repositorio.Editar(revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = revisor });
        }
    }
}
