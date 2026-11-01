package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class JogoTest {
    private Jogo jogo;

    @BeforeEach
    void preparar() {
        jogo = new Jogo();
    }

    @Test
    void deveCriarJogo() {
        assertNotNull(jogo);
    }

    @Test
    void jogoNovoTemPontuacaoZero() {
        assertEquals(0, jogo.pontuacao());
    }

    @Test
    void partidaSemPinos() {

        for (int i = 0; i < 20; i++) {
            jogo.jogar(0);
        }

        assertEquals(0, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void umPinoPorJogada() {

        for (int i = 0; i < 20; i++) {
            jogo.jogar(1);
        }

        assertEquals(20, jogo.pontuacao());
    }

    @Test
    void umSpare() {
        jogo.jogar(5);
        jogo.jogar(5);
        jogo.jogar(3);

        for (int i = 0; i < 17; i++) {
            jogo.jogar(0);
        }

        assertEquals(16, jogo.pontuacao());
    }

    @Test
    void umStrike() {
        jogo.jogar(10);
        jogo.jogar(3);
        jogo.jogar(4);

        for (int i = 0; i < 16; i++) {
            jogo.jogar(0);
        }

        assertEquals(24, jogo.pontuacao());
    }

    @Test
    void todosOsFramesComSpare() {
        for (int i = 0; i < 21; i++) {
            jogo.jogar(5);
        }

        assertEquals(150, jogo.pontuacao());
    }

    @Test
    void jogoPerfeito() {
        for (int i = 0; i < 12; i++) {
            jogo.jogar(10);
        }

        assertEquals(300, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void partidaMista() {
        int[] pinos = {
            10, 7, 3, 9, 0, 10, 0, 8,
            8, 2, 0, 6, 10, 10, 10, 8, 1
        };

        for (int pino : pinos) {
            jogo.jogar(pino);
        }

        assertEquals(167, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void rejeitaPinosNegativos() {
        assertThrows(IllegalArgumentException.class,
                () -> jogo.jogar(-1));
    }

    @Test
    void rejeitaMaisDeDezPinos() {
        assertThrows(IllegalArgumentException.class,
                () -> jogo.jogar(11));
    }

    @Test
    void rejeitaFrameComMaisDeDezPinos() {
        jogo.jogar(7);

        assertThrows(IllegalArgumentException.class,
                () -> jogo.jogar(4));
    }

    @Test
    void rejeitaJogadaAposFim() {
        for (int i = 0; i < 20; i++) {
            jogo.jogar(0);
        }

        assertTrue(jogo.encerrado());

        assertThrows(IllegalStateException.class,
                () -> jogo.jogar(1));
    }

    @Test
    void encerraAposVinteJogadasAbertas() {
        for (int i = 0; i < 20; i++) {
            jogo.jogar(1);
        }

        assertTrue(jogo.encerrado());
    }

    @Test
    void encerraAposBonusDeSpare() {
        for (int i = 0; i < 18; i++) {
            jogo.jogar(0);
        }

        jogo.jogar(5);
        jogo.jogar(5);

        assertFalse(jogo.encerrado());

        jogo.jogar(3);

        assertTrue(jogo.encerrado());
        assertEquals(13, jogo.pontuacao());
    }

    @Test
    void encerraAposDoisBonusDeStrike() {
        for (int i = 0; i < 18; i++) {
            jogo.jogar(0);
        }

        jogo.jogar(10);
        jogo.jogar(8);

        assertFalse(jogo.encerrado());

        jogo.jogar(2);

        assertTrue(jogo.encerrado());
        assertEquals(20, jogo.pontuacao());
    }

    @Test
    void jogadaInvalidaNaoAlteraFrame() {
        jogo.jogar(7);

        assertThrows(IllegalArgumentException.class,
                () -> jogo.jogar(4));

        jogo.jogar(3);

        for (int i = 0; i < 18; i++) {
            jogo.jogar(0);
        }

        assertEquals(10, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }

    @Test
    void rejeitaJogadaDepoisDoJogoPerfeito() {
        for (int i = 0; i < 12; i++) {
            jogo.jogar(10);
        }

        assertThrows(IllegalStateException.class,
                () -> jogo.jogar(0));
    }

    private void repetirJogada(int vezes, int pinos) {
        for (int i = 0; i < vezes; i++) {
            jogo.jogar(pinos);
        }
    }
}