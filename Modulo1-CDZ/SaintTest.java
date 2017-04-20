import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException; 

public class SaintTest {
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception {
        // AAA
        // 1. Arrange - Montagem dos dados de teste
        Constelacao escorpiao = new Constelacao("Escorpião");
        Armadura armaduraEscorpiao = new Armadura(escorpiao, Categoria.OURO);
        Saint milo = new GoldSaint("Milo", armaduraEscorpiao);
        // 2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        // 3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.getArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception {
        Constelacao cisne = new Constelacao("Cisne");
        Saint hyoga = new BronzeSaint("Hyoga", new Armadura(cisne, Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    
    }
    
    @Test
    public void aoCriarSaintGeneroENaoInformado() throws Exception {
        Armadura virgem = new Armadura( new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test 
    public void aoCriarSaintStatusDaVidaEVivo() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(Status.VIVO, shaka.getStatus());
    
    }
    
    @Test
    public void aoCriarSaintQuantidadeVidaEIgualACem() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        assertEquals(100, shaka.getVida(), 0);
    }
    
    @Test
    public void perderVidaSubtraiValorDoParametroDoAtributoVidaAtualDoSaint() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(8);
        assertEquals(92, shaka.getVida(), 0);
    }
    
    @Test
    public void perderVidaSubtraiVidaAtualDeCadaSaintCriadoQueInvocarOMetodo() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        Armadura cisne =  new Armadura(new Constelacao("Cisne"), Categoria.BRONZE);
        Saint hyoga = new BronzeSaint("Hyoga", cisne);
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new GoldSaint("Milo", escorpiao);
        
        shaka.perderVida(90);
        hyoga.perderVida(18);
        milo.perderVida(77);
       
        assertEquals(10, shaka.getVida(), 0);
        assertEquals(82, hyoga.getVida(), 0);
        assertEquals(23, milo.getVida(), 0);
    }
    
    @Test
    public void saintDeveTerPontosDeVidaSubtraidosACadaChamadaDoMetodoPerderVida() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        
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
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(100);
        assertEquals(0, shaka.getVida(), 0);
    }
    
    @Test
    public void perderDanoComValor1000() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(1000);
        assertEquals(0, shaka.getVida(), 0);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void perderDanoComValorMenos1000() throws Exception {
        Armadura virgem = new Armadura(new Constelacao("Virgem"), Categoria.OURO);
        Saint shaka = new GoldSaint("Shaka", virgem);
        shaka.perderVida(-1000);
        assertEquals(1100, shaka.getVida(), 0);
    }
    
    @Test
    public void deveSerPossivelAlterarOGenero() throws Exception {
        Saint jabu = new BronzeSaint("Jabu", new Armadura(new Constelacao("Unicórnio"), Categoria.BRONZE));
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }  
    
    @Test
    public void criarSaintBronzeNasceCom5SentidosDespertados() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.BRONZE));
        assertEquals(5, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintPrataNasceCom6SentidosDespertados() throws Exception {
        Saint seiya = new SilverSaint("Seiya", new Armadura(new Constelacao("Pégaso"), Categoria.PRATA));
        assertEquals(6, seiya.getQtdSentidosDespertados());
    }
    
    @Test
    public void criarSaintOuroNasceCom7SentidosDespertados() throws Exception {
        Saint seiya = new GoldSaint("Seiya", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        assertEquals(7, seiya.getQtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidaDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Mirela", new Armadura(new Constelacao("Café"), Categoria.OURO));
    }
    
    @Test
    public void alteraStatusParaMortoSeVidaMenorQueUm() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.perderVida(110);
        assertEquals(Status.MORTO, mirela.getStatus());
    }
    
    @Test
    public void verificaMetodoGetGolpesDoSaintComTresGolpes() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Golpe chute = new Golpe("Chute", 13);
        Golpe soco = new Golpe("Soco", 15);
        Golpe rasteira = new Golpe("Rasteira", 20);
        constelacaoEscorpiao.adicionarGolpe(chute);
        constelacaoEscorpiao.adicionarGolpe(soco);
        constelacaoEscorpiao.adicionarGolpe(rasteira);
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        assertEquals(chute, mirela.getGolpes().get(0));
        assertEquals(soco, mirela.getGolpes().get(1));
        assertEquals(rasteira, mirela.getGolpes().get(2));
        assertEquals(3, mirela.getGolpes().size());
        
    }
    
    @Test
    public void verificaMetodoGetGolpesDoSaintComDoisGolpes() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Golpe chute = new Golpe("Chute", 13);
        Golpe soco = new Golpe("Soco", 15);
        constelacaoEscorpiao.adicionarGolpe(chute);
        constelacaoEscorpiao.adicionarGolpe(soco);        
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        assertEquals(chute, mirela.getGolpes().get(0));
        assertEquals(soco, mirela.getGolpes().get(1));
        assertEquals(2, mirela.getGolpes().size());
        
    }
    
    @Test
    public void verificaMetodoGetGolpesDoSaintComUmGolpe() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Golpe chute = new Golpe("Chute", 13);
        constelacaoEscorpiao.adicionarGolpe(chute);
        Saint mirela = new GoldSaint("Mirela", new Armadura(constelacaoEscorpiao, Categoria.OURO));
        assertEquals(chute, mirela.getGolpes().get(0));
        assertEquals(1, mirela.getGolpes().size());
        
    }
    
    @Test
    public void insereGolpeNaConstelacaoDoSaint() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
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
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        mirela.aprenderGolpe(new Golpe("Narizada",19));
        mirela.aprenderGolpe(new Golpe("Testada",20));
        mirela.aprenderGolpe(new Golpe("Joelhada",15));
        mirela.aprenderGolpe(new Golpe("Unhada",15));
    }
    
    @Test
    public void verificaMetodoProximoGolpeQuandoPossuiTresGolpes() throws Exception {
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
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
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
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
        Saint mirela = new GoldSaint("Mirela", new Armadura(new Constelacao("Escorpião"), Categoria.OURO));
        Golpe narizada = new Golpe("Narizada",19);
        mirela.aprenderGolpe(narizada);
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
        assertEquals(narizada, mirela.getProximoGolpe());
    }
    
    @Test 
    public void getCSVComArmaduraVestida() throws Exception{
        Saint dohko = new Saint("Dohko", new Armadura(new Constelacao(""), Categoria.OURO));
        dohko.perderVida(90);
        dohko.vestirArmadura();
        String esperado = "Dohko,10.0,,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, dohko.getCSV());
        
    }
    
    @Test 
    public void getCSVSemArmaduraVestida() throws Exception{
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
    
        
    @Test 
    public void getCSVComNomeNulo() throws Exception{
        Saint june = new Saint(null, new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        String esperado = "null,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, june.getCSV());
    }
}
