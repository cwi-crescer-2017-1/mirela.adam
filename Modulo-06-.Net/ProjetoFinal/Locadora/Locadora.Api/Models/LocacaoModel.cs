using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Api.Models
{
    public class LocacaoModel
    {
        public int IdCliente { get; set; }
        public int IdProduto { get; set; }
        public int IdPacote { get; set; }
        public List<int> IdsOpcionais { get; set; }
    }
}