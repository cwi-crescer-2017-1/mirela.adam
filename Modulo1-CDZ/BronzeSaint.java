public class BronzeSaint extends Saint {    
    public BronzeSaint(String nome, String constelacao) throws Exception{
        super(nome, constelacao);
        this.qtdSentidosDespertados = 5;
        this.setArmadura(new Armadura(new Constelacao(constelacao), Categoria.BRONZE));
    }
    
}
