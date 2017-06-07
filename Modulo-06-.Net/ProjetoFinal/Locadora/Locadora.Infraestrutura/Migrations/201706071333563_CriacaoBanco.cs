namespace Locadora.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(maxLength: 300),
                        Endereco = c.String(),
                        CPF = c.String(),
                        DataNascimento = c.DateTime(nullable: false),
                        Genero = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataRetirada = c.DateTime(nullable: false),
                        DataPrevisaoEntrega = c.DateTime(nullable: false),
                        ValorPrevisao = c.Double(nullable: false),
                        DataRealEntrega = c.DateTime(),
                        ValorRealLocacao = c.Double(),
                        IdCliente = c.Int(nullable: false),
                        IdPacote = c.Int(),
                        IdProduto = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Pacote", t => t.IdPacote)
                .ForeignKey("dbo.Produto", t => t.IdProduto, cascadeDelete: true)
                .Index(t => t.IdCliente)
                .Index(t => t.IdPacote)
                .Index(t => t.IdProduto);
            
            CreateTable(
                "dbo.Opcional",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(maxLength: 300),
                        QtdEstoque = c.Int(nullable: false),
                        ValorDiaria = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pacote",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(maxLength: 300),
                        Valor = c.Double(nullable: false),
                        QtdDias = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Produto",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Descricao = c.String(maxLength: 300),
                        QtdEstoque = c.Int(nullable: false),
                        ValorDiaria = c.Double(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Guid(nullable: false),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.LocacaoOpcional",
                c => new
                    {
                        IdLocacao = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdLocacao, t.IdOpcional })
                .ForeignKey("dbo.Locacao", t => t.IdLocacao, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional, cascadeDelete: true)
                .Index(t => t.IdLocacao)
                .Index(t => t.IdOpcional);
            
            CreateTable(
                "dbo.PacoteOpcional",
                c => new
                    {
                        IdPacote = c.Int(nullable: false),
                        IdOpcional = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdPacote, t.IdOpcional })
                .ForeignKey("dbo.Pacote", t => t.IdPacote, cascadeDelete: true)
                .ForeignKey("dbo.Opcional", t => t.IdOpcional, cascadeDelete: true)
                .Index(t => t.IdPacote)
                .Index(t => t.IdOpcional);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IdUsuario = c.Guid(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Locacao", "IdProduto", "dbo.Produto");
            DropForeignKey("dbo.Locacao", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.PacoteOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.PacoteOpcional", "IdPacote", "dbo.Pacote");
            DropForeignKey("dbo.LocacaoOpcional", "IdOpcional", "dbo.Opcional");
            DropForeignKey("dbo.LocacaoOpcional", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropIndex("dbo.PacoteOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.PacoteOpcional", new[] { "IdPacote" });
            DropIndex("dbo.LocacaoOpcional", new[] { "IdOpcional" });
            DropIndex("dbo.LocacaoOpcional", new[] { "IdLocacao" });
            DropIndex("dbo.Locacao", new[] { "IdProduto" });
            DropIndex("dbo.Locacao", new[] { "IdPacote" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.PacoteOpcional");
            DropTable("dbo.LocacaoOpcional");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Produto");
            DropTable("dbo.Pacote");
            DropTable("dbo.Opcional");
            DropTable("dbo.Locacao");
            DropTable("dbo.Cliente");
        }
    }
}
