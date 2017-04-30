
public class RegraDeDano {
    private Saint golpeador;
    
    public RegraDeDano(Saint golpeador){
        this.golpeador = golpeador;
    }
    
    public double calcular(){
        double fatorDano = this.golpeador.getProximoGolpe().getFatorDano();
        if(golpeador.getArmaduraVestida()){
            fatorDano *= 1 + this.golpeador.getCategoria();
        }         
        return fatorDano;
    }
}
