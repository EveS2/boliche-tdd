package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class JogoTest {

    @Test
    void deveCriarJogo() {
        Jogo jogo = new Jogo();
    }

    @Test
    void jogoNovoTemPontuacaoZero() {
        Jogo jogo = new Jogo();
        assertEquals(0, jogo.pontuacao());
    }

    @Test
    void partidaSemPinos() {
        Jogo jogo = new Jogo();

        for (int i = 0; i < 20; i++) {
            jogo.jogar(0);
        }

        assertEquals(0, jogo.pontuacao());
        assertTrue(jogo.encerrado());
    }
}