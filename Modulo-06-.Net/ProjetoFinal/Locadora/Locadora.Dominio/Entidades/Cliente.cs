using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Endereco { get; private set; }
        public string CPF { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public Genero Genero { get; private set; }

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
