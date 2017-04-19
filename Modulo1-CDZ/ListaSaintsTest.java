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
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        assertEquals(arthur, lista.buscarPorNome("Arthur"));

    }

    @Test
    public void validarPesquisaPorNomeComRepeticaoDeNomesRetornaPrimeiroSaintEnontrado() throws Exception{
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
    public void pesquisarPorNomeEmListaVaziaRetornaNull(){
        ListaSaints lista = new ListaSaints();
        assertNull(lista.buscarPorNome("Tales"));  
    }
    
    @Test
    public void buscarPorCategoriaInexistente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        assertEquals(new ArrayList<Saint>(), lista.buscaPorCategoria(Categoria.BRONZE));
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
        assertEquals(2, lista.buscaPorCategoria(Categoria.OURO).size());
        assertEquals(prata, lista.buscaPorCategoria(Categoria.PRATA));
        assertEquals(3, lista.buscaPorCategoria(Categoria.PRATA).size());
        assertEquals(bronze, lista.buscaPorCategoria(Categoria.BRONZE));
        assertEquals(1, lista.buscaPorCategoria(Categoria.BRONZE).size());
    }

    @Test
    public void validarBuscaPorStatus() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        Saint lucas = new GoldSaint("Lucas", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint manu = new SilverSaint("Manu", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint vivian = new SilverSaint("Vivian", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        mirela.perderVida(190);
        arthur.perderVida(50);
        carlos.perderVida(1010);
        lucas.perderVida(100);
        manu.perderVida(80);
        vivian.perderVida(30);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        lista.adicionar(lucas);
        lista.adicionar(manu);
        lista.adicionar(vivian);
        ArrayList<Saint> vivos = new ArrayList<>();
        ArrayList<Saint> mortos = new ArrayList<>();
        vivos.add(arthur);
        vivos.add(manu);
        vivos.add(vivian);      
        mortos.add(mirela);
        mortos.add(carlos);
        mortos.add(lucas);
        assertEquals(vivos, lista.buscaPorStatus(Status.VIVO));
        assertEquals(mortos, lista.buscaPorStatus(Status.MORTO));
    }

    @Test
    public void testarGetSaintMaiorVidaEmListaComTresSaintsNaLista() throws Exception {
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(190);
        arthur.perderVida(50);
        carlos.perderVida(50);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        assertEquals(arthur, lista.getSaintMaiorVida());    
    }

    @Test
    public void testarGetSaintMaiorVidaEmListaComUmSaintNaLista() throws Exception {
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        mirela.perderVida(190);
        lista.adicionar(mirela);
        assertEquals(mirela, lista.getSaintMaiorVida());    
    }
    
    @Test
    public void getSaintMaiorVidaComListaVazia(){
        ListaSaints listaSaints = new ListaSaints();
        Saint maiorVida = listaSaints.getSaintMaiorVida();
        assertEquals(null, maiorVida);
    }
    
    @Test
    public void getSaintMenorVidaComListaVazia(){
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertEquals(null, menorVida);
    }

    
    @Test
    public void testarGetSaintMenorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(30);
        arthur.perderVida(50);
        carlos.perderVida(30);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);
        assertEquals(arthur, lista.getSaintMenorVida());    
        mirela.perderVida(20);      
        assertEquals(mirela, lista.getSaintMenorVida());    
    }

    @Test 
    public void testarMétodoOrdenar() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(97);
        carlos.perderVida(25);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(arthur);
        listaOrdenada.add(carlos);
        listaOrdenada.add(mirela);
        lista.ordenar();
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test 
    public void testarMétodoOrdenarPiorCaso() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(20);
        carlos.perderVida(30);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(carlos);
        listaOrdenada.add(arthur);
        listaOrdenada.add(mirela);
        lista.ordenar();
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test 
    public void testarMétodoOrdenarComListaJaOrdenada() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(20);
        carlos.perderVida(30);
        lista.adicionar(carlos);
        lista.adicionar(arthur);
        lista.adicionar(mirela);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(carlos);
        listaOrdenada.add(arthur);
        listaOrdenada.add(mirela);
        lista.ordenar();
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test
	public void ordenarListaComApenasUmElemento() throws Exception{
      	ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint arthur = new GoldSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.OURO));     
		arthur.perderVida(20);
		lista.adicionar(arthur);
		lista.ordenar();
		ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(arthur);
        assertEquals(listaOrdenada, lista.todos());
	}

	 @Test 
    public void ordenarComListaVazia() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        listaSaints.ordenar(); 
        ArrayList<Saint> resultado = listaSaints.todos(); 
        assertEquals(new ArrayList<Saint>(), resultado); 
    } 

	@Test 
    public void ordenarComListaDeValoresIguais() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        listaSaints.adicionar(shun); 
        listaSaints.adicionar(misty); 
        listaSaints.adicionar(june); 
        listaSaints.ordenar(); 
        ArrayList<Saint> resultado = listaSaints.todos(); 
        assertEquals(shun, resultado.get(0)); 
        assertEquals(misty, resultado.get(1)); 
        assertEquals(june, resultado.get(2)); 
    } 


    @Test 
    public void testarMétodoOrdenarComTipoOrdenacaoAscendente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(97);
        carlos.perderVida(25);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(arthur);
        listaOrdenada.add(carlos);
        listaOrdenada.add(mirela);
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test 
    public void testarMétodoOrdenarPiorCasoComTipoOrdenacaoAscendente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(20);
        carlos.perderVida(30);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(carlos);
        listaOrdenada.add(arthur);
        listaOrdenada.add(mirela);
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test 
    public void testarMétodoOrdenarComListaJaOrdenadaComTipoOrdenacaoAscendente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(20);
        carlos.perderVida(30);
        lista.adicionar(carlos);
        lista.adicionar(arthur);
        lista.adicionar(mirela);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(carlos);
        listaOrdenada.add(arthur);
        listaOrdenada.add(mirela);
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test
	public void ordenarListaComApenasUmElementoComTipoOrdenacaoAscendente() throws Exception{
      	ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint arthur = new GoldSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.OURO));     
		arthur.perderVida(20);
		lista.adicionar(arthur);
		lista.ordenar(TipoOrdenacao.ASCENDENTE);
		ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(arthur);
        assertEquals(listaOrdenada, lista.todos());
	}

	 @Test 
    public void ordenarComListaVaziaComTipoOrdenacaoAscendente() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE); 
        ArrayList<Saint> resultado = listaSaints.todos(); 
        assertEquals(new ArrayList<Saint>(), resultado); 
    } 

	@Test 
    public void ordenarComListaDeValoresIguaisComTipoOrdenacaoAscendente() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        listaSaints.adicionar(shun); 
        listaSaints.adicionar(misty); 
        listaSaints.adicionar(june); 
        listaSaints.ordenar(TipoOrdenacao.ASCENDENTE); 
        ArrayList<Saint> resultado = listaSaints.todos(); 
        assertEquals(shun, resultado.get(0)); 
        assertEquals(misty, resultado.get(1)); 
        assertEquals(june, resultado.get(2)); 
    } 

    @Test 
    public void testarMétodoOrdenarComTipoOrdenacaoDescendente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(97);
        carlos.perderVida(25);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        
        listaOrdenada.add(mirela);
        listaOrdenada.add(carlos);
        listaOrdenada.add(arthur);
		lista.ordenar(TipoOrdenacao.DESCENDENTE);
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test 
    public void testarMétodoOrdenarPiorCasoComTipoOrdenacaoDescendente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(20);
        carlos.perderVida(30);
        lista.adicionar(mirela);
        lista.adicionar(arthur);
        lista.adicionar(carlos);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(mirela);
        listaOrdenada.add(arthur);
        listaOrdenada.add(carlos);
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test 
    public void testarMétodoOrdenarComListaJaOrdenadaComTipoOrdenacaoDescendente() throws Exception{
        ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        Saint arthur = new SilverSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.PRATA));
        Saint carlos = new BronzeSaint("Carlos", new Armadura(constelacaoEscorpiao, Categoria.BRONZE));
        mirela.perderVida(10);
        arthur.perderVida(20);
        carlos.perderVida(30);
        lista.adicionar(carlos);
        lista.adicionar(arthur);
        lista.adicionar(mirela);            
        ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(mirela);
        listaOrdenada.add(arthur);
        listaOrdenada.add(carlos);
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        assertEquals(listaOrdenada, lista.todos());
    }

	@Test
	public void ordenarListaComApenasUmElementoComTipoOrdenacaoDescendente() throws Exception{
      	ListaSaints lista = new ListaSaints();
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Saint arthur = new GoldSaint("Arthur", new Armadura(constelacaoEscorpiao, Categoria.OURO));     
		arthur.perderVida(20);
		lista.adicionar(arthur);
		lista.ordenar(TipoOrdenacao.DESCENDENTE);
		ArrayList<Saint> listaOrdenada = new ArrayList<>();
        listaOrdenada.add(arthur);
        assertEquals(listaOrdenada, lista.todos());
	}

	 @Test 
    public void ordenarComListaVaziaComTipoOrdenacaoDescendente() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE); 
        ArrayList<Saint> resultado = listaSaints.todos(); 
        assertEquals(new ArrayList<Saint>(), resultado); 
    } 

	@Test 
    public void ordenarComListaDeValoresIguaisComTipoOrdenacaoDescendente() throws Exception { 
        ListaSaints listaSaints = new ListaSaints(); 
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        listaSaints.adicionar(shun); 
        listaSaints.adicionar(misty); 
        listaSaints.adicionar(june); 
        listaSaints.ordenar(TipoOrdenacao.DESCENDENTE); 
        ArrayList<Saint> resultado = listaSaints.todos(); 
        assertEquals(shun, resultado.get(0)); 
        assertEquals(misty, resultado.get(1)); 
        assertEquals(june, resultado.get(2)); 
    } 

}