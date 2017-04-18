import java.util.ArrayList;

public class ListaSaints {
    ArrayList<Saint> listaSaint = new ArrayList<>();
    //adicionar(Saint): adiciona Saint ao final da lista
    public void adicionar(Saint saint){
        listaSaint.add(saint);
    }

    //get(indice): busca o Saint na posição informada por parâmetro
    public Saint get(int i){
        return listaSaint.get(i);
    }
    
    //todos(): retorna toda lista de Saint.
    public ArrayList todos(){
        return listaSaint;
    }
    
    //remover(Saint):
    public void remover(Saint saint){
        for (Saint s : listaSaint) {
            if(s.equals(saint)){
                listaSaint.remove(s);
            }
        }
        
    }
    
    //buscarPorNome(String): retorna o primeiro Saint que encontrar com o mesmo nome informado no parâmetro
    public Saint buscarPorNome(String nome){
        for(Saint s : listaSaint){
            if(s.getNome().equals(nome)){
                return s;
            }
        }
        return null;
    }
    
    
}