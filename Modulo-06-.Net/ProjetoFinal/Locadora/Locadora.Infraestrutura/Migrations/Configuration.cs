namespace Locadora.Infraestrutura.Migrations
{
    using Locadora.Dominio.Entidades;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<Locadora.Infraestrutura.Contexto>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(Locadora.Infraestrutura.Contexto context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //

            if (!context.Usuarios.Where(i => i.Email == "colaborador@cwi").Any())
            {
                var usuario = new Usuario("colaborador@cwi", "123456");
                usuario.AtribuirPermissoes("Colaborador");
                context.Usuarios.Add(usuario);
                context.SaveChanges();
            }

            if (!context.Usuarios.Where(i => i.Email == "gerente@cwi").Any())
            {
                var usuario = new Usuario("gerente@cwi", "123456");
                usuario.AtribuirPermissoes("Gerente");
                context.Usuarios.Add(usuario);
                context.SaveChanges();
            }
        }
    }
}
