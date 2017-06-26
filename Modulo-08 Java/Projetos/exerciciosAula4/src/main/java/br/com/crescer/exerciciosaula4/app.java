package br.com.crescer.exerciciosaula4;
/**
 *
 * @author Mirela
 */
public class app {
    public static void main(String[] args) {
        Genero g = new Genero();
        g.setDescricao("Comédia");
        GeneroDao gd = new GeneroDao();
        
        /*
        gd.save(g);
        Funcionario f = new Funcionario();
        f.setNome("Mirea Haag");
        f.setRg("1097923931");
        fd.save(f);
        FuncionarioDao fd = new FuncionarioDao();
        g = gd.loadById(50L);
        gd.remove(g);
        */
        
        System.out.println(gd.findAll());
        
        for(Genero ge : gd.findAll()){
            System.out.println(ge.getDescricao());
        }
        
        
    }
}
