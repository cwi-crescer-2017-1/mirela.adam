public class SilverSaint extends Saint{
   public SilverSaint(String nome, Armadura armadura) throws Exception{
       super(nome, armadura);
       this.qtdSentidosDespertados = 6;
    }
    
    public SilverSaint(String nome, String constelacao) throws Exception{
        this(nome, new Armadura(new Constelacao(constelacao), Categoria.PRATA));
    }
}
