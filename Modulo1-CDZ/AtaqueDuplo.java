public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;

     public AtaqueDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar(){
        Sorteador sorteador = new DadoD3();
        ChanceAtaqueDuplo chance = new ChanceAtaqueDuplo(sorteador);
        
        if(chance.lancaOsDados()){
            Golpear golpear = new Golpear(this.golpeador, this.golpeado);
            golpear.executar();
            golpear.executar();
        } else {
        
        }
    }
}

/*   
    public void executar(){
        int fatorDano = this.golpeador.getProximoGolpe().getFatorDano();
        if(golpeador.getArmaduraVestida()){
            fatorDano *= 1 + this.golpeador.getCategoria();
            this.golpeado.perderVida(fatorDano);
        } else {
            this.golpeado.perderVida(fatorDano);
        }
    }
    
    public boolean equals(Object outro){
        Golpear outroGolpear = (Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador) && this.golpeado.equals(outroGolpear.golpeado);
    }
}
*/