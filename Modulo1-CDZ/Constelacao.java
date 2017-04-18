public class Constelacao {
   private String nome;
   private Golpe[] golpes = new Golpe[3];
   
   public Constelacao(String nome){
       this.nome = nome;
   }
   
   public void adicionarGolpe(Golpe golpe) throws Exception{            
           for (int indice = 0; indice < 3; indice++) {

               if(this.golpes[indice] == null){
                   this.golpes[indice] = golpe;
                   break;
                } else if (indice == 2) {
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
