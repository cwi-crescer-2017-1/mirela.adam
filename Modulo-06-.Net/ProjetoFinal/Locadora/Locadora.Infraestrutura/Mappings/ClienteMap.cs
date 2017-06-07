using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mappings
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {

        public ClienteMap()
        {
            ToTable("Cliente");
            Property(p => p.Nome).HasMaxLength(300);
        }
    }
}
