import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ListaSaintsTest {
   @Test
   public void validarRemover() throws Exception{
        ListaSaints lista = new ListaSaints();

        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new GoldSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint carlos = new GoldSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        lista.remover(arthur);
        
        assertEquals(2, lista.todos().size());
        assertEquals(mirela, lista.get(0));
        assertEquals(carlos, lista.get(1));
   }
   
   @Test
   public void validarPesquisaPorNome() throws Exception{
        ListaSaints lista = new ListaSaints();

        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new GoldSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint carlos = new GoldSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint mirela2 = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        lista.adicionar(mirela2);
        
        assertEquals(mirela, lista.buscarPorNome("Mirela"));
        
   }
   
   @Test
   public void pesquisarPorNomeQueNaoPossuiNaListRetornaNull() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new GoldSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint carlos = new GoldSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint mirela2 = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        lista.adicionar(mirela2);
        
        assertNull(lista.buscarPorNome("Tales"));   
   }
   
   @Test
   public void validarBuscaPorCategoria() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        Saint lucas = new GoldSaint("Lucas", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint manu = new SilverSaint("Manu", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint vivian = new SilverSaint("Vivian", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        
        ArrayList<Saint> ouro = new ArrayList<>();
        ArrayList<Saint> prata = new ArrayList<>();
        ArrayList<Saint> bronze = new ArrayList<>();
        
        ouro.add(mirela);
        ouro.add(lucas);
        prata.add(arthur);
        prata.add(manu);
        prata.add(vivian);
        bronze.add(carlos);        
        
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        lista.adicionar(lucas);
        lista.adicionar(manu);
        lista.adicionar(vivian);
        
        assertEquals(ouro, lista.buscaPorCategoria(Categoria.OURO));
        assertEquals(prata, lista.buscaPorCategoria(Categoria.PRATA));
        assertEquals(bronze, lista.buscaPorCategoria(Categoria.BRONZE));
   }
   
   
}
