package br.edu.ifsp.boliche;

public class Jogo {
    private int quantidadeJogadas = 0;
    private int pontos = 0;

    public void jogar(int pinos) {
        pontos += pinos;
        quantidadeJogadas++;
    }

    public int pontuacao() {
        return pontos;
    }

    public boolean encerrado() {
        return quantidadeJogadas == 20;
    }
}
