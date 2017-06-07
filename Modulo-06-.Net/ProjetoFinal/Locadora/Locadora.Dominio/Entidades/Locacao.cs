using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Locacao
    {
        public int Id { get; set; }
        public DateTime DataRetirada { get; set; }
        public DateTime DataPrevisaoEntrega { get; set; }
        public double ValorPrevisao { get; set; }
        public DateTime? DataRealEntrega { get; set; }
        public double? ValorRealLocacao { get; set; }
        public Cliente Cliente { get; set; }
        public Produto Produto { get; set; }
        public Pacote Pacote { get; set; }
        public List<Opcional> Opcionais { get; set; }

        protected Locacao() { } //EF 

    }
}
