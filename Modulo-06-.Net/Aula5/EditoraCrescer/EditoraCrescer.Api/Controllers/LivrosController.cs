using EditoraCrescer.Infraestrutura;
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
    [RoutePrefix("api/Livros")]
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        // api/livros  
        [HttpGet]
        public IHttpActionResult ObterLivros()
        {
            var livros = repositorio.Obter();
            return Ok(new { dados = livros });
        }

        // api/livros/isbn
        [HttpGet]
        [Route("{isbn:int}")]
        public IHttpActionResult ObterLivroPorIsbn(int isbn)
        {
            var livro = repositorio.ObterPorIsbn(isbn);
            return Ok(new { dados = livro });
        }

        // api/livros/genero
        [HttpGet]
        [Route("PorGenero/{genero}")]
        public IHttpActionResult ObterLivrosPorGenero(string genero)
        {
            var livros = repositorio.ObterPorGenero(genero);
            return Ok(new { dados = livros });
        }

        [HttpPost]
        // api/livros
        public IHttpActionResult IncluirLivro(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dados = livro });
        }

        // api/livros/isbn
        [HttpDelete]
        [Route("{isbn}")]
        public IHttpActionResult ExcluirLivro(int isbn)
        {
            repositorio.Excluir(isbn);
            return Ok();
        }

        // api/livros/isbn
        [HttpPut]
        [Route("{isbn}")]
        public HttpResponseMessage EditarLivro(int isbn, Livro livro)
        {
            var mensagens = new List<string>();
            if (isbn != livro.Isbn)
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - ISBNs diferentes" } });

            if (!repositorio.VerificaExistenciaLivro(isbn))
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagens = new string[] { "Dados inconsistentes - Livro não cadastrado" } });

            repositorio.Editar(livro);
            return Request.CreateResponse(HttpStatusCode.OK, new { dados = livro });
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();

            base.Dispose(disposing);
        }
    }
}
