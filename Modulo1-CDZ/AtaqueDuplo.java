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
            double vidaAntesDeSerGolpeado = golpeado.getVida();
            Golpear golpear = new Golpear(this.golpeador, this.golpeado);
            golpear.executar();
            golpeado.perderVida(vidaAntesDeSerGolpeado - golpeado.getVida());
        } else {
            Golpear golpear = new Golpear(this.golpeador, this.golpeado);
            golpear.executar();
        }
    }
}