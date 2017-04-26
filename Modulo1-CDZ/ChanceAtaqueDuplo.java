public class ChanceAtaqueDuplo {
    private Sorteador sorteador;
    
    public ChanceAtaqueDuplo(Sorteador sorteador){
        this.sorteador = sorteador;
    }
    
    public boolean lancaOsDados(){
        int resultado = this.sorteador.sortear();
        return resultado % 2 == 0;
    }
} 