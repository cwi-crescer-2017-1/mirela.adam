public class AtaqueDuplo implements Movimento {
    private Saint golpeador, golpeado;
    private Sorteador sorteador;

     public AtaqueDuplo(Saint golpeador, Saint golpeado, Sorteador sorteador){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }
    
    public void executar(){
        ChanceAtaqueDuplo chance = new ChanceAtaqueDuplo(this.sorteador);
        double dano = new RegraDeDano(this.golpeador).calcular();
        if(chance.lancaOsDados()){
            this.golpeado.perderVida(dano * 2);
        } else {
            this.golpeado.perderVida(dano); 
            this.golpeador.perderVida(this.golpeador.getVida() * 0.05);
        }
    }
}