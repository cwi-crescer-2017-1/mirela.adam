using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Pacote
    {
        public int Id { get; set; }
        public string Descricao { get; set; }
        public double Valor { get; set; }
        public int QtdDias { get; set; }
        public List<Opcional> Opcionais { get; set; }

        protected Pacote() { } //EF 
    }
}
