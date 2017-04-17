public class GoldSaint extends Saint {
    public GoldSaint(String nome, Armadura armadura) throws Exception {
        super(nome, armadura);
        this.qtdSentidosDespertados = 7;
        String constelacao = armadura.getConstelacao();
            
            if( !constelacao.equals("Áries") 
                && !constelacao.equals("Touro") 
                && !constelacao.equals("Escorpião") 
                && !constelacao.equals("Virgem")
                && !constelacao.equals("Gêmeos")
                && !constelacao.equals("Câncer")
                && !constelacao.equals("Leão")
                && !constelacao.equals("Libra")
                && !constelacao.equals("Sagitário")
                && !constelacao.equals("Capricórnio")
                && !constelacao.equals("Peixes")
                && !constelacao.equals("Aquário")
        
                ){
                throw new Exception("Constelação inválida");
            }
    }
}
