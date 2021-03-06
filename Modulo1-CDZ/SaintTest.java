import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException; 

public class SaintTest {
    
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Saint milo = new GoldSaint("Milo", "Escorpião");
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        assertEquals(false, hyoga.getArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test 
    public void aoCriarSaintStatusDaVidaEVivo() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        assertEquals(Status.VIVO, shaka.getStatus());

    }

    @Test
    public void aoCriarSaintQuantidadeVidaEIgualACem() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        assertEquals(100, shaka.getVida(), 0);
    }

    @Test
    public void perderVidaSubtraiValorDoParametroDoAtributoVidaAtualDoSaint() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        shaka.perderVida(8);
        assertEquals(92, shaka.getVida(), 0);
    }

    @Test
    public void perderVidaSubtraiVidaAtualDeCadaSaintCriadoQueInvocarOMetodo() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint milo = new GoldSaint("Milo", "Escorpião");
        shaka.perderVida(90);
        hyoga.perderVida(18);
        milo.perderVida(77);
        assertEquals(10, shaka.getVida(), 0);
        assertEquals(82, hyoga.getVida(), 0);
        assertEquals(23, milo.getVida(), 0);
    }

    @Test
    public void saintDeveTerPontosDeVidaSubtraidosACadaChamadaDoMetodoPerderVida() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        shaka.perderVida(10);
        assertEquals(90, shaka.getVida(), 0);
        shaka.perderVida(22);
        assertEquals(68, shaka.getVida(), 0);
        shaka.perderVida(18);
        assertEquals(50, shaka.getVida(), 0);
        shaka.perderVida(33);
        assertEquals(17, shaka.getVida(), 0);
    }

    @Test
    public void perderDanoComValor100() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        shaka.perderVida(100);
        assertEquals(0, shaka.getVida(), 0);
    }

    @Test
    public void perderDanoComValor1000() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        shaka.perderVida(1000);
        assertEquals(0, shaka.getVida(), 0);
    }

    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        Saint shaka = new GoldSaint("Shaka", "Virgem");
        shaka.perderVida(-1000);
        assertEquals(1100, shaka.getVida(), 0);
    }

    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", "Unicórnio");
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }  

    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint seiya = new SilverSaint("Seiya", "Pégaso");
        assertEquals(6, seiya.getQtdSentidosDespertados());
    }

    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint seiya = new GoldSaint("Seiya", "Escorpião");
        assertEquals(7, seiya.getQtdSentidosDespertados());
    }

    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Mirela", "Café");
    }

    @Test
    public void alteraStatusParaMortoSeVidaMenorQueUm() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        mirela.perderVida(110);
        assertEquals(Status.MORTO, mirela.getStatus());
    }

    @Test
    public void verificaMetodoGetGolpesDoSaintComTresGolpes() throws Exception {
        Golpe chute = new Golpe("Chute", 13);
        Golpe soco = new Golpe("Soco", 15);
        Golpe rasteira = new Golpe("Rasteira", 20);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        mirela.getConstelacao().adicionarGolpe(rasteira);
        assertEquals(chute, mirela.getGolpes().get(0));
        assertEquals(soco, mirela.getGolpes().get(1));
        assertEquals(rasteira, mirela.getGolpes().get(2));
        assertEquals(3, mirela.getGolpes().size());

    }

    @Test
    public void verificaMetodoGetGolpesDoSaintComDoisGolpes() throws Exception {
        Golpe chute = new Golpe("Chute", 13);
        Golpe soco = new Golpe("Soco", 15);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        mirela.getConstelacao().adicionarGolpe(soco);
        assertEquals(chute, mirela.getGolpes().get(0));
        assertEquals(soco, mirela.getGolpes().get(1));
        assertEquals(2, mirela.getGolpes().size());

    }

    @Test
    public void verificaMetodoGetGolpesDoSaintComUmGolpe() throws Exception {
        Golpe chute = new Golpe("Chute", 13);
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        mirela.getConstelacao().adicionarGolpe(chute);
        assertEquals(chute, mirela.getGolpes().get(0));
        assertEquals(1, mirela.getGolpes().size());

    }

    @Test
    public void insereGolpeNaConstelacaoDoSaint() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Golpe narizada = new Golpe("Narizada",19);
        Golpe testada = new Golpe("Testada",20);
        Golpe joelhada = new Golpe("Joelhada",15);
        mirela.aprenderGolpe(narizada);
        mirela.aprenderGolpe(testada);
        mirela.aprenderGolpe(joelhada);
        assertEquals(narizada, mirela.getGolpes().get(0));
        assertEquals(testada, mirela.getGolpes().get(1));
        assertEquals(joelhada, mirela.getGolpes().get(2));

    }  

    @Test
    public void inserirMaisDeTresGolpesDeveSerPermitido() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        mirela.aprenderGolpe(new Golpe("Testada",20));
        mirela.aprenderGolpe(new Golpe("Joelhada",15));
        mirela.aprenderGolpe(new Golpe("Unhada",15));
    }

    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiTresGolpes() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Golpe narizada = new Golpe("Narizada",19);
        Golpe testada = new Golpe("Testada",20);
        Golpe joelhada = new Golpe("Joelhada",15);
        mirela.aprenderGolpe(narizada);
        mirela.aprenderGolpe(testada);
        mirela.aprenderGolpe(joelhada);
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(testada, mirela.getProximoGolpe());
        assertEquals(joelhada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(testada, mirela.getProximoGolpe());
    }

    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiDoisGolpes() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Golpe narizada = new Golpe("Narizada",19);
        Golpe testada = new Golpe("Testada",20);
        mirela.aprenderGolpe(narizada);
        mirela.aprenderGolpe(testada);
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(testada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(testada, mirela.getProximoGolpe());
    }

    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiUmGolpe() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Golpe narizada = new Golpe("Narizada",19);
        mirela.aprenderGolpe(narizada);
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
    }

    @Test 
    public void getCSVComArmaduraVestida() throws Exception {
        Saint dohko = new GoldSaint("Dohko", "Escorpião");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        String esperado = "Dohko,10.0,Escorpião,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, dohko.getCSV());

    }

    @Test 
    public void getCSVSemArmaduraVestida() throws Exception {
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }

    @Test 
    public void getCSVComNomeNulo() throws Exception {
        Saint june = new BronzeSaint(null, "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "null,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }

    @Test 
    public void verificaMetodoGetProximoMovimento() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Movimento movimento1 = new VestirArmadura(mirela);
        Movimento movimento2 = new Golpear(mirela, new SilverSaint("Tales", "Aquário"));
        mirela.adicionarMovimento(movimento1);
        mirela.adicionarMovimento(movimento2);
        assertEquals(movimento1, mirela.getProximoMovimento());
        assertEquals(movimento2, mirela.getProximoMovimento());
        assertEquals(movimento1, mirela.getProximoMovimento());        
        assertEquals(movimento2, mirela.getProximoMovimento());
    }

    @Test(expected=ArithmeticException.class)
    public void getProximoMovimentoComListaVazia() throws Exception {
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");
        Movimento movimento = hyoga.getProximoMovimento();
    }

    @Test 
    public void verificaMetodoGetProximoMovimentoComApenasUmMovimento() throws Exception {
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        Movimento movimento1 = new VestirArmadura(mirela);
        mirela.adicionarMovimento(movimento1);
        assertEquals(movimento1, mirela.getProximoMovimento());
        assertEquals(movimento1, mirela.getProximoMovimento());
    }

    @Test
    public void verificaIdAtribuidoAosSaintsCriados() throws Exception {
        int qtdSaints = Saint.getQtdSaints();
        Saint mirela = new GoldSaint("Mirela", "Escorpião");
        assertEquals(mirela.getId(), Saint.getAcumuladorQtdSaints());
    } 

    @Test 
    public void verificaIdsAtribuidosCincoSaintsCriados() throws Exception {
        int idAntes = Saint.getAcumuladorQtdSaints();
        assertEquals(idAntes + 1, new GoldSaint("Mirela1", "Escorpião").getId());
        assertEquals(idAntes + 2, new BronzeSaint("Mirela2", "Escorpião").getId());
        assertEquals(idAntes + 3, new GoldSaint("Mirela3", "Escorpião").getId());
        assertEquals(idAntes + 4, new GoldSaint("Mirela4", "Escorpião").getId());
        assertEquals(idAntes + 5, new GoldSaint("Mirela5", "Escorpião").getId());
    }
    
     @Test 
    public void criarUmSaintQtdSaintsDeveTerUmAMais() throws Exception { 
        Saint shun = new BronzeSaint("Shun", "Andrômeda"); 
        assertEquals(1, Saint.getQtdSaints()); 
    } 
 
    @Test 
    public void criarDoisSaintQtdSaintsDeveTerDoisAMais() throws Exception { 
        new BronzeSaint("Shun", "Andrômeda"); 
        new SilverSaint("Marin", "Águia"); 
        assertEquals(2, Saint.getQtdSaints()); 
    } 
 
 
    @Test 
    public void criarDuzentosSaintsQtdSaintsDeveTerDuzentosAMais() throws Exception { 
        final int quantidade = 200; 
        for (int i = 0; i < quantidade; i++) { 
            new BronzeSaint("Bronze " + i, "Constelação " + i); 
        } 
        assertEquals(quantidade, Saint.getQtdSaints()); 
    } 
    
    @Test 
    public void golpearDeveAdicionarMovimentoGolpear() throws Exception { 
        Saint saga = new GoldSaint("Saga", "Gêmeos"); 
        saga.aprenderGolpe(new Golpe("Outra dimensão", 10)); 
        Saint seiya = new BronzeSaint("Seiya", "Pégaso"); 
        saga.golpear(seiya); 
        Golpear golpear = new Golpear(saga, seiya); 
        assertEquals(golpear, saga.getProximoMovimento()); 
    } 
    
    @Test
    public void despirArmaduraDeveSetarArmaduraVestidaIgualAFalse() throws Exception {
        Saint saga = new GoldSaint("Saga", "Gêmeos"); 
        saga.vestirArmadura();
        assertTrue(saga.getArmaduraVestida());
        saga.despirArmadura();
        assertFalse(saga.getArmaduraVestida());
    }
    
    @Test
    public void criarSaintEDepoisLimparDeveIncrementar() throws Exception, Throwable{
        int idAntes = Saint.getAcumuladorQtdSaints();
        Saint hyoga = new BronzeSaint("Hyoga","Cisne");
        hyoga = null;
        
        System.gc();
        Saint miro = new GoldSaint("Miro", "Gêmeos"); 
        assertEquals(idAntes + 2, miro.getId());
    }
}
