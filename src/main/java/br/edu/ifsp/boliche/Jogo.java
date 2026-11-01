
package br.edu.ifsp.boliche;

public class Jogo {

    private final int[] jogadas = new int[21];
    private int quantidadeJogadas = 0;

    private int frameAtual = 1;
    private int primeiraJogada = -1;
    private int jogadasNoDecimo = 0;
    private int primeiroPinoDecimo = -1;
    private int segundoPinoDecimo = -1;
    private boolean terminou = false;

    public void jogar(int pinos) {
        if (terminou) {
            throw new IllegalStateException(
                "A partida ja terminou"
            );
        }

        if (pinos < 0 || pinos > 10) {
            throw new IllegalArgumentException(
                "Quantidade de pinos invalida"
            );
        }

        if (frameAtual < 10) {
            jogarFrameNormal(pinos);
        } else {
            jogarDecimoFrame(pinos);
        }

        jogadas[quantidadeJogadas++] = pinos;
    }

    private void jogarFrameNormal(int pinos) {
        if (primeiraJogada == -1) {
            if (pinos == 10) {
                frameAtual++;
            } else {
                primeiraJogada = pinos;
            }
        } else {
            if (primeiraJogada + pinos > 10) {
                throw new IllegalArgumentException(
                    "Frame excede dez pinos"
                );
            }

            primeiraJogada = -1;
            frameAtual++;
        }
    }

    private void jogarDecimoFrame(int pinos) {
        if (jogadasNoDecimo == 0) {
            primeiroPinoDecimo = pinos;
            jogadasNoDecimo++;
            return;
        }

        if (jogadasNoDecimo == 1) {
            if (primeiroPinoDecimo != 10
                    && primeiroPinoDecimo + pinos > 10) {
                throw new IllegalArgumentException(
                    "Frame excede dez pinos"
                );
            }

            segundoPinoDecimo = pinos;
            jogadasNoDecimo++;

            if (primeiroPinoDecimo + pinos < 10) {
                terminou = true;
            }
            return;
        }

        if (primeiroPinoDecimo == 10
                && segundoPinoDecimo < 10
                && segundoPinoDecimo + pinos > 10) {
            throw new IllegalArgumentException(
                "Bonus excede dez pinos"
            );
        }

        jogadasNoDecimo++;
        terminou = true;
    }

    public int pontuacao() {
        int total = 0;
        int indice = 0;

        for (int frame = 1; frame <= 10; frame++) {
            if (indice >= quantidadeJogadas) {
                break;
            }

            if (jogadas[indice] == 10) {
                total += 10
                    + valor(indice + 1)
                    + valor(indice + 2);
                indice++;
            } else if (indice + 1 < quantidadeJogadas
                    && jogadas[indice]
                    + jogadas[indice + 1] == 10) {
                total += 10 + valor(indice + 2);
                indice += 2;
            } else {
                total += jogadas[indice]
                    + valor(indice + 1);
                indice += 2;
            }
        }

        return total;
    }

    private int valor(int indice) {
        if (indice >= quantidadeJogadas) {
            return 0;
        }
        return jogadas[indice];
    }

    public boolean encerrado() {
        return terminou;
    }
}
