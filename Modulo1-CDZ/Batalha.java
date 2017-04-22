public class Batalha
{
    private Saint saint1;
    private Saint saint2;
    // private double dano = 10;

    public Batalha(Saint saint1, Saint saint2) {
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public void iniciar(){
        double dano = 10;
        Saint estaAtacando;

        if (saint1.getArmadura().getCategoria().getValor() >= saint2.getArmadura().getCategoria().getValor()) {
            estaAtacando = saint1;
        } else {
            estaAtacando = saint2;
        }

        while(!saint1.getStatus().equals(Status.MORTO) || !saint2.getStatus().equals(Status.MORTO)){
            if(estaAtacando.equals(saint1)){
                saint2.perderVida(dano);
                if(saint2.getVida()==0){
                    break;
                } else {
                    estaAtacando = saint2;
                }

            } else {
                saint1.perderVida(dano);
                if(saint1.getVida()==0){
                    break;
                } else {
                    estaAtacando = saint1;
                }
            }           
        }
    }
}