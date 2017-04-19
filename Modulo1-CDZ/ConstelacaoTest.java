import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    @Test
    public void constelacaoSemGolpesPossuiArrayVazio() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        assertEquals(0, constelacaoEscorpiao.getGolpes().size());

    }

    @Test
    public void adicionaTresGolpesParaConstelacao()throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Golpe chute = new Golpe("Chute", 13);
        Golpe soco = new Golpe("Soco", 15);
        Golpe rasteira = new Golpe("Rasteira", 10);
        
        constelacaoEscorpiao.adicionarGolpe(chute);
        constelacaoEscorpiao.adicionarGolpe(soco);
        constelacaoEscorpiao.adicionarGolpe(rasteira);

        assertEquals(chute, constelacaoEscorpiao.getGolpes().get(0));
        assertEquals(soco, constelacaoEscorpiao.getGolpes().get(1));
        assertEquals(rasteira, constelacaoEscorpiao.getGolpes().get(2));
    }

    @Test
    public void adicionaDoisGolpesParaConstelacao() throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Golpe chute = new Golpe("Chute", 13);
        Golpe soco = new Golpe("Soco", 15);
        
        constelacaoEscorpiao.adicionarGolpe(chute);
        constelacaoEscorpiao.adicionarGolpe(soco);

        assertEquals(chute, constelacaoEscorpiao.getGolpes().get(0));
        assertEquals(soco, constelacaoEscorpiao.getGolpes().get(1));
        assertEquals(2, constelacaoEscorpiao.getGolpes().size());

    }

    @Test
    public void adicionaUmGolpeParaConstelacao() throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        Golpe chute = new Golpe("Chute", 13);
        
        constelacaoEscorpiao.adicionarGolpe(chute);

        assertEquals(chute, constelacaoEscorpiao.getGolpes().get(0));
        assertEquals(1, constelacaoEscorpiao.getGolpes().size());

    }

    @Test
    public void aplicacaoDevePermitirAdicionarMaisDeTresGolpes() throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");

        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Soco", 15));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Rasteira", 10));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Voadora", 16));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Cabelada", 2));
        
        assertEquals(5, constelacaoEscorpiao.getGolpes().size());
    }
}
