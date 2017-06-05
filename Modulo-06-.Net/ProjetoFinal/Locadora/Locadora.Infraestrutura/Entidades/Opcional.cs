using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Entidades
{
    public class Opcional
    {
        public int Id { get; set; }
        public string Descricao { get; set; }
        public int QtdEstoque { get; set; }
        public double ValorDiaria { get; set; }
        public int IdConsole { get; set; }
        public Console Console { get; set; }
    }
}
