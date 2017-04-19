import java.util.ArrayList;

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
    }
    
    public ArrayList<Saint> buscaPorCategoria(Categoria categoria){
        ArrayList<Saint> saintsCategorizados = new ArrayList<>();
        
         for(Saint s : listaSaint){
            if(s.getArmadura().getCategoria() == categoria){
                saintsCategorizados.add(s);
            }
         }
        return saintsCategorizados;
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
        Saint maior = this.listaSaint.get(0);
        for(Saint s : listaSaint){
            if(s.getVida() > maior.getVida()){
               maior = s;
            }
        }
        return maior;
    } 
    
    public Saint getSaintMenorVida(){
    Saint menor = this.listaSaint.get(0);
        for(Saint s : listaSaint){
            if(s.getVida() < menor.getVida()){
               menor = s;
            }
        }
        return menor;
    }
    
    public void ordenar(){
        Saint aux;
        for(int i = 0; i < listaSaint.size(); i++){
            for(int j = 0; j < listaSaint.size()-1; j++){
                if(this.listaSaint.get(j).getVida() > this.listaSaint.get(j + 1).getVida()){
                    aux = this.listaSaint.get(j);
                    this.listaSaint.set(j, listaSaint.get(j+1));
                    this.listaSaint.set(j+1, aux);
			    }
		    }
        }
    }
}