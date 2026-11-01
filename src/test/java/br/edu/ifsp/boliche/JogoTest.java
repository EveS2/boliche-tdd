package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}