package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
}