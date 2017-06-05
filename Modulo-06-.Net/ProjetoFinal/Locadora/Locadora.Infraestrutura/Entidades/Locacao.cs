using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public DateTime DataRetirada { get; set; }
        public DateTime DataPrevisaoEntrega { get; set; }
        public double ValorPrevisao { get; set; }
        public DateTime? DataRealEntrega { get; set; }
        public double? ValorRealLocacao { get; set; }
        public int idCliente { get; set; }
        public Cliente Cliente { get; set; }
    }
}
