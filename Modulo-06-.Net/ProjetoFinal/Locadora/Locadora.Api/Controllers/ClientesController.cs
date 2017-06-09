using Locadora.Api.App_Start;
using Locadora.Api.Models;
using Locadora.Dominio.Entidades;
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
    [RoutePrefix("api/Clientes")]
    public class ClientesController : ApiController
    {
        private ClienteRepositorio repositorio = new ClienteRepositorio();

        //GET api/Clientes
        [HttpGet]
        public IHttpActionResult ObterClientes()
        {
            var clientes = repositorio.Obter();
            return Ok(new { dados = clientes });
        }

        //GET api/Clientes/{cpf}
        [Route("{cpf}")]
        [HttpGet]
        public IHttpActionResult ObterClientePorCpf(string cpf)
        {
            var cliente = repositorio.ObterClientePorCpf(cpf);
            return Ok(new { dados = cliente });
        }

        //POST api/Clientes 
        [HttpPost]
        public IHttpActionResult IncluirCliente(ClienteModel clienteModel)
        {
            var cliente = new Cliente(clienteModel.Nome, clienteModel.Endereco, clienteModel.CPF, clienteModel.DataNascimento, clienteModel.Genero);
            repositorio.Criar(cliente);
            return Ok(cliente);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
                repositorio.Dispose();

            base.Dispose(disposing);
        }
    }
}
