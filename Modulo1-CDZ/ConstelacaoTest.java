import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    @Test
    public void constelacaoSemGolpesPossuiIndicesComValoresNulos() throws Exception {
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");

        assertNull(constelacaoEscorpiao.getGolpes()[0]);
        assertNull(constelacaoEscorpiao.getGolpes()[1]);
        assertNull(constelacaoEscorpiao.getGolpes()[2]);

    }

    @Test
    public void adicionaTresGolpesParaConstelacao()throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");

        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Soco", 15));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Rasteira", 10));

        assertEquals("Chute", constelacaoEscorpiao.getGolpes()[0].getNome());
        assertEquals("Soco", constelacaoEscorpiao.getGolpes()[1].getNome());
        assertEquals("Rasteira", constelacaoEscorpiao.getGolpes()[2].getNome());

    }

    @Test
    public void adicionaDoisGolpesParaConstelacao() throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");

        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Soco", 15));

        assertEquals("Chute", constelacaoEscorpiao.getGolpes()[0].getNome());
        assertEquals("Soco", constelacaoEscorpiao.getGolpes()[1].getNome());
        assertNull(constelacaoEscorpiao.getGolpes()[2]);

    }

    @Test
    public void adicionaUmGolpeParaConstelacao() throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));

        assertEquals("Chute", constelacaoEscorpiao.getGolpes()[0].getNome());
        assertNull(constelacaoEscorpiao.getGolpes()[1]);
        assertNull(constelacaoEscorpiao.getGolpes()[2]);

    }

    @Test(expected=Exception.class)
    public void aoAdicionarMaisDeTresGolpesAUmaConstelacaoDeveLancarException() throws Exception{
        Constelacao constelacaoEscorpiao = new Constelacao("Escorpião");

        constelacaoEscorpiao.adicionarGolpe(new Golpe("Chute", 13));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Soco", 15));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Rasteira", 10));
        constelacaoEscorpiao.adicionarGolpe(new Golpe("Voadora", 10));
    }
}
