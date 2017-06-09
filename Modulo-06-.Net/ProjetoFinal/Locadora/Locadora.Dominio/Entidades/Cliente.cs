using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public string CPF { get; set; }
        public DateTime DataNascimento { get; set; }
        public Genero Genero { get; set; }

        protected Cliente() { }

        public Cliente (string nome, string endereco, string cpf, DateTime dataNasc, Genero genero)
        {
            Nome = nome;
            Endereco = endereco;
            CPF = cpf;
            DataNascimento = dataNasc;
            Genero = genero;
        }
    }
}
