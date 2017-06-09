﻿using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mappings
{
    public class OpcionalMap : EntityTypeConfiguration<Opcional>
    {

        public OpcionalMap()
        {
            ToTable("Opcional");
            Property(p => p.Descricao).HasMaxLength(300);
        }
    }
}