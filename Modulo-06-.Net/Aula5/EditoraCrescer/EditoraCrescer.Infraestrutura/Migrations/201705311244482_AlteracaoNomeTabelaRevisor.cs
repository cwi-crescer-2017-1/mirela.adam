namespace EditoraCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlteracaoNomeTabelaRevisor : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Revisors", newName: "Revisores");
            AlterColumn("dbo.Revisores", "Nome", c => c.String(maxLength: 300));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Revisores", "Nome", c => c.String());
            RenameTable(name: "dbo.Revisores", newName: "Revisors");
        }
    }
}
