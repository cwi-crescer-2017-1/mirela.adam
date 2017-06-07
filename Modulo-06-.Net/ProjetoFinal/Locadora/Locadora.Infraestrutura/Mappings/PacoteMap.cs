using Locadora.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Mappings
{
    public class PacoteMap : EntityTypeConfiguration<Pacote>
    {

        public PacoteMap()
        {
            ToTable("Pacote");
            Property(p => p.Descricao).HasMaxLength(300);

            HasMany(x => x.Opcionais).WithMany().Map(x =>
            {
                x.MapLeftKey("IdPacote");
                x.MapRightKey("IdOpcional");
                x.ToTable("PacoteOpcional");
            });
        }
    }
}
