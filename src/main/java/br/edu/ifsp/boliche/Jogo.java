package br.edu.ifsp.boliche;

public class Jogo {

    private final int[] jogadas = new int[21];
    private int quantidadeJogadas = 0;

    public void jogar(int pinos) {
        jogadas[quantidadeJogadas++] = pinos;
    }

    public int pontuacao() {
        int total = 0;
        int indice = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (jogadas[indice] == 10) {
                total += 10 + jogadas[indice + 1] + jogadas[indice + 2];
                indice++;
            } else if (jogadas[indice] + jogadas[indice + 1] == 10) {
                total += 10 + jogadas[indice + 2];
                indice += 2;
            } else {
                total += jogadas[indice] + jogadas[indice + 1];
                indice += 2;
            }
        }

        return total;
    }

    public boolean encerrado() {
        if (quantidadeJogadas == 12) {
            boolean perfeito = true;

            for (int i = 0; i < 12; i++) {
                if (jogadas[i] != 10) {
                    perfeito = false;
                }
            }

            if (perfeito) {
                return true;
            }
        }

        return quantidadeJogadas == 20;
    }
}