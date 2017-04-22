public class Golpear implements Movimento{
    private Saint golpeador, golpeado;

    public Golpear(Saint golpeador, Saint golpeado){
        double fatorDano = golpeador.getProximoGolpe().getFatorDano();
        if(golpeador.getArmaduraVestida()){
            golpeado.perderVida(fatorDano * (1 + golpeador.getArmadura().getCategoria().getValor()));
        } else {
            golpeado.perderVida(fatorDano);
        }
    }
    
    public void executar(){}
}
