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
    [RoutePrefix("api/Autores")]
    public class AutoresController : ApiController
    {
        private AutorRepositorio repositorio = new AutorRepositorio();

        //GET api/Autores
        [HttpGet]
        public IHttpActionResult ObterAutores()
        {
            var autores = repositorio.Obter();
            return Ok(new { dados = autores });
        }

        //GET api/Autores/{id}
        [HttpGet]
        public IHttpActionResult ObterAutorPorId(int id)
        {
            var autor = repositorio.ObterPorId(id);
            return Ok(new { dados = autor });
        }

        //GET api/Autores/{id}/Livros (obtém todos os livros do autor)
        [HttpGet]
        [Route("{id}/Livros")]
        public IHttpActionResult ObterLivrosPorAutor(int id)
        {
            var livrosDoAutor = repositorio.ObterLivrosDoAutor(id);
            return Ok(new { dados = livrosDoAutor });
        }

        //POST api/Autores 
        [HttpPost]
        public IHttpActionResult IncluirAutor(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok(autor);
        }

        //DELETE api/Autores/{id}
        [HttpDelete]
        public IHttpActionResult ExcluirAutor(int id)
        {
            repositorio.Excluir(id);
            return Ok();
        }

        //PUT api/Autores/{id}
        [HttpPut]
        public HttpResponseMessage EditarAutor(int id, Autor autor)
        {
            var mensagens = new List<string>();
            if (id != autor.Id)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - Id's diferentes" } });

            if (!repositorio.VerificaExistenciaAutor(id))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - Autor não cadastrado" } });

            repositorio.Editar(autor);
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = autor });
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();

            base.Dispose(disposing);
        }
    }
}
