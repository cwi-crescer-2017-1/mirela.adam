public class Golpear implements Movimento{
    private Saint golpeador, golpeado;

    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar(){
        int fatorDano = this.golpeador.getProximoGolpe().getFatorDano();
        if(golpeador.getArmaduraVestida()){
            fatorDano *= 1 + this.golpeador.getCategoria();
            this.golpeado.perderVida(fatorDano);
        } else {
            this.golpeado.perderVida(fatorDano);
        }
    }
}
