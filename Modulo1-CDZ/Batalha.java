public class Batalha {
    private Saint saint1;
    private Saint saint2;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar(){
        Saint estaAtacando;
        boolean nenhumMorto=true;

        if (saint1.getCategoria() >= saint2.getCategoria()) {
            estaAtacando = this.saint1;
        } else {
            estaAtacando = this.saint2;
        }
        
        while(nenhumMorto){
			//pegando proximo movimento do saint que esta atacando
            Movimento proximoMovimento = estaAtacando.getProximoMovimento();
			proximoMovimento.executar();            
			estaAtacando = estaAtacando == this.saint1 ? this.saint2 : saint1;
            nenhumMorto = this.saint1.getStatus() != Status.MORTO && this.saint2.getStatus() != Status.MORTO;
        }
    }
}