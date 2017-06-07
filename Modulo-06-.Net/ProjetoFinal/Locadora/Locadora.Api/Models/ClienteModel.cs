using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Api.Models
{
    public class ClienteModel
    {
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public string CPF { get; set; }
        public DateTime DataNascimento { get; set; }
        public Genero Genero { get; set; }
    }
}