using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Opcional
    {
        public int Id { get; set; }
        public string Descricao { get; set; }
        public int QtdEstoque { get; set; }
        public double ValorDiaria { get; set; }

        protected Opcional() { } //EF 
    }
}
