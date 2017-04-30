public class Golpear implements Movimento{
    private Saint golpeador, golpeado;

    public Golpear(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }
    
    public void executar(){
        double dano = new RegraDeDano(this.golpeador).calcular();
        this.golpeado.perderVida(dano);
    }
    
    public boolean equals(Object outro){
        Golpear outroGolpear = (Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador) && this.golpeado.equals(outroGolpear.golpeado);
    }
}
