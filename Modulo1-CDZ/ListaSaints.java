import java.util.ArrayList;
import java.util.stream.*;
import java.util.stream.Collectors;

public class ListaSaints {
    private ArrayList<Saint> listaSaint = new ArrayList<>();

    public void adicionar(Saint saint){
        this.listaSaint.add(saint);
    }

    public Saint get(int indice){
        return this.listaSaint.get(indice);
    }

    public ArrayList<Saint> todos(){
        return this.listaSaint;
    }

    public void remover(Saint saint){
        this.listaSaint.remove(saint);       
    }

    public Saint buscarPorNome(String nome){
        for(Saint s : listaSaint){
            if(s.getNome().equals(nome)){
                return s;
            }
        }
        return null;
        /*
        return this.listaSaint.stream()
        .filter(s -> s.getNome().equals(nome))
        .findFirst()
        .orElse(null);
         */
    }

    public ArrayList<Saint> buscaPorCategoria(Categoria categoria){
        ArrayList<Saint> saintsCategorizados = new ArrayList<>();
        /*
        for(Saint s : listaSaint){
        if(s.getArmadura().getCategoria().equals(categoria)){
        saintsCategorizados.add(s);
        }
        }
        return saintsCategorizados;*/
        return (ArrayList<Saint>)this.listaSaint.stream()
        .filter(s -> s.getArmadura().getCategoria().equals(categoria))
        .collect(Collectors.toList());
    }

    public ArrayList<Saint> buscaPorStatus(Status status){
        ArrayList<Saint> saintsPorStatus = new ArrayList<>();
        for(Saint s : listaSaint){
            if(s.getStatus() == status){
                saintsPorStatus.add(s);
            }
        }
        return saintsPorStatus;
    }

    public Saint getSaintMaiorVida(){

        if(listaSaint.isEmpty()){
            return null;
        }

        Saint maior = this.listaSaint.get(0);
        /*  for(Saint s : listaSaint){
        if(s.getVida() > maior.getVida()){
        maior = s;
        }
        } */

        for(int i = 1; i < this.listaSaint.size(); i++){
            Saint saint = this.listaSaint.get(i);
            boolean encontreiMaior = saint.getVida() > maior.getVida();

            if(encontreiMaior){
                maior = saint;
            }
        }

        return maior;
    } 

    public Saint getSaintMenorVida(){
        if(listaSaint.isEmpty()){
            return null;
        }
        Saint menor = this.listaSaint.get(0);
        for(int i = 1; i < this.listaSaint.size(); i++){
            Saint saint = this.listaSaint.get(i);
            boolean encontreiMenor = saint.getVida() < menor.getVida();

            if(encontreiMenor){
                menor = saint;
            }
        }
        return menor;
    }

    public void ordenar(){
        Saint aux;
        boolean posicoesSendoTrocadas;

        do{
            posicoesSendoTrocadas=false;
            for(int i = 0; i < this.listaSaint.size()-1; i++){
                Saint atual = this.listaSaint.get(i);
                Saint proximo = this.listaSaint.get(i+1); 

                boolean precisaTrocar = atual.getVida() > proximo.getVida();
                if(precisaTrocar){
                    this.listaSaint.set(i, proximo);
                    this.listaSaint.set(i+1, atual);
                    posicoesSendoTrocadas = true;
                }              
            }
        } while(posicoesSendoTrocadas);
    }

    public void ordenar(TipoOrdenacao tipoOrdenacao){
        Saint aux;
        boolean posicoesSendoTrocadas;

        if(tipoOrdenacao.equals(TipoOrdenacao.ASCENDENTE)){
            do{
                posicoesSendoTrocadas=false;
                for(int i = 0; i < this.listaSaint.size()-1; i++){
                    Saint atual = this.listaSaint.get(i);
                    Saint proximo = this.listaSaint.get(i+1); 

                    boolean precisaTrocar = atual.getVida() > proximo.getVida();
                    if(precisaTrocar){
                        this.listaSaint.set(i, proximo);
                        this.listaSaint.set(i+1, atual);
                        posicoesSendoTrocadas = true;
                    }              
                }
            } while(posicoesSendoTrocadas);
        } else if(tipoOrdenacao.equals(TipoOrdenacao.DESCENDENTE)) { 

           do{
                posicoesSendoTrocadas=false;
                for(int i = 0; i < this.listaSaint.size()-1; i++){
                    Saint atual = this.listaSaint.get(i);
                    Saint proximo = this.listaSaint.get(i+1); 

                    boolean precisaTrocar = atual.getVida() < proximo.getVida();
                    if(precisaTrocar){
                        this.listaSaint.set(i, proximo);
                        this.listaSaint.set(i+1, atual);
                        posicoesSendoTrocadas = true;
                    }              
                }
            } while(posicoesSendoTrocadas);

        }
    }

    public ArrayList<Saint> unir(ArrayList<Saint> lista1){
        ArrayList<Saint> listaUnida = new ArrayList<>();

        if(!this.listaSaint.isEmpty() || !lista1.isEmpty()){
            listaUnida.addAll(lista1);
            listaUnida.addAll(listaSaint);

            return listaUnida;
        } else {
            return null;
        }
    }

    public ArrayList<Saint> diff(ArrayList<Saint> lista1){
        ArrayList<Saint> listaDiff = new ArrayList<>();

        if(!this.listaSaint.isEmpty()){
            for(Saint saintListaAtual : listaSaint){
                boolean encontrouSaint = false;
                for(Saint saintParam : lista1){
                    encontrouSaint = saintParam.equals(saintListaAtual);
                    if(encontrouSaint){
                        break;
                    }
                }

                if(!encontrouSaint) {
                    listaDiff.add(saintListaAtual);
                }
            }

            return listaDiff;
        }else{
            return null;
        }
    }

    public ArrayList<Saint> intersec(ArrayList<Saint> lista1){
        ArrayList<Saint> listaIntersec = new ArrayList<>();

        if(!this.listaSaint.isEmpty() && !lista1.isEmpty()){
            for(Saint saintListaAtual : listaSaint){                
                for(Saint saintParam : lista1){
                    if(saintListaAtual.equals(saintParam)){
                        listaIntersec.add(saintParam);
                    }
                }
            }
        }
        
        if(listaIntersec.size() > 0){
            return listaIntersec;
        } else {
            return null;
        }
    }

    public String getCSV(){
        String csv="";

        if(!listaSaint.isEmpty()){
            for(Saint s : listaSaint){
                csv += s.getNome() + "," + s.getVida() + "," + s.getConstelacao().getNome() +  ","+ s.getArmadura().getCategoria() + "," + 
                s.getStatus() + "," + s.getGenero() + "," + s.getArmaduraVestida() + "\n";
            }
        }else {
            return null;
        }
        return csv;
    }
}