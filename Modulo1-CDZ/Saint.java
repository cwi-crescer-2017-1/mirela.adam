import java.security.InvalidParameterException; 

public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int proximoGolpe = -1;
    //private int acumuladorProximoGolpe = 0;
    
    public Saint(String nome, Armadura armadura) throws Exception {
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
    
    public Golpe[] getGolpes(){
        return this.getArmadura().getConstelacao().getGolpes();
    }
    
    public Constelacao getConstelacao(){
        return this.armadura.getConstelacao();
    }
    
    public void aprenderGolpe(Golpe golpe) throws Exception{
        this.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe(){
        /*Golpe[] golpes = getGolpes(); 
        int posicao = this.acumuladorProximoGolpe % golpes.length; 
        this.acumuladorProximoGolpe++; 
        return golpes[posicao]; */
        
        if(proximoGolpe == 2) {
            proximoGolpe = -1;
        }
        
        proximoGolpe++;
        
        if(this.getArmadura().getConstelacao().getGolpes()[proximoGolpe] != null) {
            return this.getConstelacao().getGolpes()[proximoGolpe];
        } else {
            proximoGolpe = 0;
            return this.getConstelacao().getGolpes()[proximoGolpe];
        }
       
    }
  
}