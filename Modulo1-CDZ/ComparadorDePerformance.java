import java.util.*; 
public class ComparadorDePerformance {
    public void exemplosHashMap() {
 
        HashMap<String, String> agendaTelefonica = new HashMap<>();
 
        agendaTelefonica.put("Bernardo", "555555555");
 
        agendaTelefonica.put("André Nunes", "Número do dinheiro");
 

 
        boolean contemBernardo = agendaTelefonica.containsKey("Bernardo");
 
        System.out.println("containsKey(\"Bernardo\") ? " + contemBernardo);
 

 
        boolean contemPHP = agendaTelefonica.containsKey("PHP");
 
        System.out.println("containsKey(\"PHP\") ? " + contemPHP);
 

 
        for (String numero : agendaTelefonica.values()) {
 
            System.out.println(numero);
 
        }
 

 
        for (Map.Entry<String, String> par : agendaTelefonica.entrySet()) {
 
            System.out.println(par.getKey() + " - " + par.getValue());
 
        }
 

 
    }
 

 
    private static Saint pesquisarSaintArraylist(ArrayList<Saint> saints, String nome) {
 
        for (Saint saint : saints) {
 
            if (saint.getNome().equals(nome)) {
 
                return saint;
 
            }
 
        }
 
        return null;
 
    }
 

 
    private static Saint pesquisarPorHashMap(HashMap<String, Saint> saints, String nome) {
 
        return saints.get(nome);
 
    }
 

 
    public static void main(String[] args) throws Exception {
 

 
        ArrayList<Saint> arrayList = new ArrayList<>();
 
        HashMap<String, Saint> hashmap = new HashMap<>();
 

 
        final long tamanhoArray = 600000;
 
        for (long i = 0; i < tamanhoArray; i++) {
 
            Saint saint = new BronzeSaint("Saint " + i, "Constelação " + i);
 
            arrayList.add(saint);
 
            hashmap.put(saint.getNome(), saint);
 
        }
 

 
        long inicio1 = System.currentTimeMillis();
 
        Saint saint = pesquisarSaintArraylist(arrayList, "Saint 590000");
 
        System.out.println(saint);
 
        long fim1 = System.currentTimeMillis();
 
        System.out.println((fim1 - inicio1) / 1000.0);
 

 
        long inicio2 = System.currentTimeMillis();
 
        Saint saint2 = pesquisarPorHashMap(hashmap, "Saint 590000");
 
        System.out.println(saint2);
 
        long fim2 = System.currentTimeMillis();
 
        System.out.println((fim2 - inicio2) / 1000.0);
 
    }
 
}