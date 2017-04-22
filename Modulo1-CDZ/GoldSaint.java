public class GoldSaint extends Saint {
    
    public GoldSaint(String nome, String constelacao) throws Exception{
        super(nome, new Armadura(new Constelacao(constelacao), Categoria.OURO));
        this.qtdSentidosDespertados = 7;        
        Constelacao constelacaoArmadura = this.getArmadura().getConstelacao();
            
            if( !constelacaoArmadura.getNome().equals("Áries") 
                && !constelacaoArmadura.getNome().equals("Touro") 
                && !constelacaoArmadura.getNome().equals("Escorpião") 
                && !constelacaoArmadura.getNome().equals("Virgem")
                && !constelacaoArmadura.getNome().equals("Gêmeos")
                && !constelacaoArmadura.getNome().equals("Câncer")
                && !constelacaoArmadura.getNome().equals("Leão")
                && !constelacaoArmadura.getNome().equals("Libra")
                && !constelacaoArmadura.getNome().equals("Sagitário")
                && !constelacaoArmadura.getNome().equals("Capricórnio")
                && !constelacaoArmadura.getNome().equals("Peixes")
                && !constelacaoArmadura.getNome().equals("Aquário")
        
                ){
                throw new Exception("Constelação inválida");
            } 
    }
}
