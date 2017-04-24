public class Golpear implements Movimento{
    private Saint golpeador, golpeado;

    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar(){
        double fatorDano = this.golpeador.getProximoGolpe().getFatorDano();
        if(golpeador.getArmaduraVestida()){
            this.golpeado.perderVida(fatorDano * (1 + this.golpeador.getArmadura().getCategoria().getValor()));
        } else {
            this.golpeado.perderVida(fatorDano);
        }
    }
}
