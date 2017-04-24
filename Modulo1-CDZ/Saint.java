import java.security.InvalidParameterException; 
import java.util.ArrayList;

public abstract class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int acumuladorProximoGolpe = 0;
    private ArrayList<Movimento> movimentos = new ArrayList<>();
    private int acumuladorProximoMovimento = 0;
    
    protected Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
    }
    
    public void setArmadura(Armadura armadura){
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

    public String getNome(){
        return this.nome;   
    }
    
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public void perderVida(double dano) throws InvalidParameterException {
       if(dano >=0 ){
           if(this.status != (Status.MORTO)){
               this.vida = this.vida - dano;
        
               if(this.vida < 1){
                   this.status = Status.MORTO;
                   this.vida = 0;
               }
           }
       } else {
           throw new InvalidParameterException("Parâmetro dano com valor negativo.");
       }
    }   
    
    public Armadura getArmadura(){
        return this.armadura;
    }
    
    public int getQtdSentidosDespertados(){
        return this.qtdSentidosDespertados;
    }
    
    public ArrayList<Golpe> getGolpes(){
        return this.getArmadura().getConstelacao().getGolpes();
    }
    
    public Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }
    
    public int getCategoria(){
        return this.armadura.getCategoria().getValor();
    } 
    
    public void aprenderGolpe(Golpe golpe) throws Exception{
        this.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe(){
        ArrayList<Golpe> golpes = getGolpes(); 
        int posicao = this.acumuladorProximoGolpe % golpes.size(); 
        this.acumuladorProximoGolpe++; 
        return golpes.get(posicao); 
    }
    
    public String getCSV(){
        return String.format(
               "%s,%s,%s,%s,%s,%s,%s",
               this.nome, this.vida, this.getConstelacao().getNome(), this.armadura.getCategoria(), this.status, this.genero, this.armaduraVestida
               );
    }
    
    public void adicionarMovimento(Movimento movimento){
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento(){
        int posicao = this.acumuladorProximoMovimento % movimentos.size(); 
        this.acumuladorProximoMovimento++; 
        return movimentos.get(posicao); 
    }
    
  
}