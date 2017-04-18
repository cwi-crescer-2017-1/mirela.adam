public class Constelacao {
   private String nome;
   private Golpe[] golpes = new Golpe[3];
   
   public Constelacao(String nome){
       this.nome = nome;
   }
   
   public void adicionarGolpe(Golpe golpe) throws Exception{  
       
           // golpes[ultimaPosicaoPreenchida++] = golpe; 
           for (int i = 0; i < this.golpes.length; i++) {
               if(this.golpes[i] == null){
                   this.golpes[i] = golpe;
                   break;
                } else if (i == 2) {
                   throw new Exception("Impossível adicionar mais de três golpes à esta Constelação");
                }   
                
           }   
   }
   
   public Golpe[] getGolpes(){
       return this.golpes;
   }
   
   public String getNome(){
       return this.nome;
   }
}
