﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Entidades
{
    public class Permissao
    {
        public int Id { get; set; }
        public string Nome { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
        public Permissao()
        {

        }
    }
}
