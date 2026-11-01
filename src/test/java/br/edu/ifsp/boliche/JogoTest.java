package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}