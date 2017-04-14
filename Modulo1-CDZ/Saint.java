public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private StatusVida statusVida = StatusVida.VIVO;
    private double vidaAtual = 100;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public void  vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    //camelCase
    public boolean getArmaduraVestida() {
        return this.armaduraVestida;
    }
    
    public Genero getGenero(){
        return this.genero;
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public StatusVida getStatusVida(){
        return this.statusVida;
    }
    
    public double getVidaAtual(){
        return this.vidaAtual;
    }
    
    public void perderVida(double qtdd){
        this.vidaAtual = this.vidaAtual - qtdd;
    }
    
    public Armadura getArmadura(){
        return armadura;
    }
  
}