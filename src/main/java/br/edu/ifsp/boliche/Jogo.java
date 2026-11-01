package br.edu.ifsp.boliche;

public class Jogo {
    private int quantidadeJogadas = 0;

    public int pontuacao() {
        return 0;
    }

    public void jogar(int pinos) {
        quantidadeJogadas++;
    }

    public boolean encerrado() {
        return quantidadeJogadas == 20;
    }
}
