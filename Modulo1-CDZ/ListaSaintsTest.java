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

    //TipoOrdenacao.ASCENDENTE
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

    //TipoOrdenacao.DESCENDENTE
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
    
    //getCSV
    @Test
    public void verificaRetornoGetCSVComDoisSaints() throws Exception{
        ListaSaints lista = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);

        Saint dohko = new Saint("Dohko", new Armadura(new Constelacao(""), Categoria.OURO));
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);

        String csv = lista.getCSV();
        assertEquals("June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\r\nDohko,10.0,,OURO,VIVO,NAO_INFORMADO,true\r\n",csv);
    }
    
     @Test
    public void verificaRetornoGetCSVComUmSaint() throws Exception{
        ListaSaints lista = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        assertEquals("June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\r\n", lista.getCSV());
    }

    @Test
    public void retornoGetCsvComListaVaziaDeveRetornarStringVazia() throws Exception{
        ListaSaints lista = new ListaSaints();
        assertEquals("",lista.getCSV());
    }
    
    //unir 
    @Test
    public void unirDuasListas() throws Exception {
        ListaSaints lista1 = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        lista1.adicionar(shun); 
        lista1.adicionar(misty); 
        lista1.adicionar(june); 

        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint mirela = new Saint("Mirela", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint carlos = new SilverSaint("Carlos", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint arthur = new Saint("Arthur", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        lista2.add(mirela); 
        lista2.add(carlos); 
        lista2.add(arthur); 
        ArrayList<Saint> listaEsperada = new ArrayList<>();

        listaEsperada.add(mirela);
        listaEsperada.add(carlos);
        listaEsperada.add(arthur);
        listaEsperada.add(shun);
        listaEsperada.add(misty);
        listaEsperada.add(june);
        assertEquals(listaEsperada, lista1.unir(lista2));        
        assertEquals(listaEsperada.size(), lista1.todos().size()+lista2.size());
    }

    @Test
    public void unirListasQuandoAtualNaoPossuiElementos() throws Exception {
        ListaSaints lista1 = new ListaSaints();

        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint mirela = new Saint("Mirela", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint carlos = new SilverSaint("Carlos", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint arthur = new Saint("Arthur", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        lista2.add(mirela); 
        lista2.add(carlos); 
        lista2.add(arthur); 

        ArrayList<Saint> lista3Unida = lista1.unir(lista2);
        ArrayList<Saint> listaEsperada = new ArrayList<>();

        listaEsperada.add(mirela);
        listaEsperada.add(carlos);
        listaEsperada.add(arthur);

        assertEquals(listaEsperada, lista3Unida); 
        assertEquals(listaEsperada.size(), lista1.todos().size()+lista2.size());
    }

    @Test
    public void unirListasQuandoListaDoParametroNaoPossuiElementos() throws Exception{
        ListaSaints lista1 = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        lista1.adicionar(shun); 
        lista1.adicionar(misty); 
        lista1.adicionar(june); 

        ArrayList<Saint> lista2 = new ArrayList<>();
        ArrayList<Saint> listaEsperada = new ArrayList<>();

        listaEsperada.add(shun);
        listaEsperada.add(misty);
        listaEsperada.add(june);

        assertEquals(listaEsperada, lista1.unir(lista2)); 
        assertEquals(listaEsperada.size(), lista1.todos().size()+lista2.size());
    }

    @Test
    public void retornarNuloQuandoParametroEListaAtualEstiveremVazios(){
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        assertNull(lista1.unir(lista2));
    }

    //diff
    @Test
    public void validarMetodoDiffComDuasListasComDados() throws Exception {
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 

        lista1.adicionar(june);
        lista1.adicionar(misty);
        lista1.adicionar(shun);
        lista2.add(misty);

        ArrayList<Saint> listaEsperada = new ArrayList<>();
        listaEsperada.add(june);
        listaEsperada.add(shun);

        assertEquals(listaEsperada, lista1.diff(lista2)); 
    }

    @Test
    public void validarMetodoDiffQuandoListaAtualNaoPossuiDadosDeveRetornarNull() throws Exception {
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        lista2.add(misty);
        assertNull(lista1.diff(lista2));

    }

    @Test
    public void validarMetodoDiffQuandoListaDoParametroEstaVazia() throws Exception {
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();

        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 

        lista1.adicionar(june);
        lista1.adicionar(misty);
        lista1.adicionar(shun);

        ArrayList<Saint> listaEsperada = new ArrayList<>();
        listaEsperada.add(june);
        listaEsperada.add(misty);
        listaEsperada.add(shun);

        assertEquals(listaEsperada, lista1.diff(lista2)); 
    }

    //intersec
    @Test
    public void validarMetodoInterescComDuasListasComDadosQuePossuamElementosIguais() throws Exception{
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        Saint mirela = new Saint("Mirela", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 

        lista1.adicionar(shun); 
        lista1.adicionar(misty); 
        lista1.adicionar(june);      
        lista2.add(mirela); 
        lista2.add(june); 
        lista2.add(misty); 

        ArrayList<Saint> listaEsperada = new ArrayList<>();
        listaEsperada.add(misty);
        listaEsperada.add(june);

        assertEquals(listaEsperada, lista1.intersec(lista2));     
    }

    @Test
    public void validarMetodoInterescComDuasListasComDadosQueNaoPossuamElementosIguais() throws Exception{ 
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA)); 
        Saint shun = new Saint("Shun", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE)); 
        Saint mirela = new Saint("Mirela", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint arthur = new Saint("Arthur", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 

        lista1.adicionar(shun); 
        lista1.adicionar(misty); 
        lista1.adicionar(june);      
        lista2.add(mirela); 
        lista2.add(arthur); 

        assertNull(lista1.intersec(lista2));     
    }

    @Test
    public void validarMetodoInterescQuandoListaAtualNaoPossuiElementos() throws Exception { 
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint mirela = new Saint("Mirela", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint arthur = new Saint("Arthur", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        lista2.add(mirela); 
        lista2.add(arthur); 

        assertNull(lista1.intersec(lista2));  
    }

    @Test
    public void validarMetodoInterescQuandoListaDoParametroNaoPossuiElementos() throws Exception{ 
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        Saint mirela = new Saint("Mirela", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        Saint arthur = new Saint("Arthur", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE)); 
        lista1.adicionar(mirela); 
        lista1.adicionar(arthur); 

        assertNull(lista1.intersec(lista2));  
    }

    @Test
    public void validarMetodoInterescQuandoAsDuasListasEstaoVazias(){ 
        ListaSaints lista1 = new ListaSaints();
        ArrayList<Saint> lista2 = new ArrayList<>();
        assertNull(lista1.intersec(lista2));  
    }
}