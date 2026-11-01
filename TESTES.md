# Plano de testes — Jogo de Boliche

## Objetivo
Implementar a classe Jogo utilizando TDD, conforme demonstrado por Uncle Bob.

## Testes planejados

- [x] Verificar a configuração do JUnit.
- [x] Criar uma instância de Jogo.
- [x] Verificar a pontuação inicial.
- [x] Partida sem derrubar pinos: 0 pontos.
- [x] Partida com um pino por jogada: 20 pontos.
- [x] Partida com um spare: 16 pontos.
- [x] Partida com um strike: 24 pontos.
- [x] Todos os frames com spare: 150 pontos.
- [x] Jogo perfeito: 300 pontos.
- [x] Partida mista: 167 pontos.
- [x] V1: rejeitar jogadas negativas.
- [] V1: rejeitar jogadas maiores que 10.
- [x] V2: rejeitar segunda jogada que ultrapasse 10 pinos.
- [x] V3: rejeitar jogadas após o encerramento.
- [x] Verificar encerramento após décimo frame aberto.
- [x] Verificar encerramento após bônus de spare.
- [x] Verificar encerramento após bônus de strike.

## Metodologia

Cada comportamento será desenvolvido em ciclos RED, GREEN e REFACTOR.

Os testes serão executados com `mvn test`, e cada fase terá um commit próprio no Git.

## Resultado da implementação

A classe Jogo foi desenvolvida utilizando ciclos de TDD, conforme demonstrado por Uncle Bob.

Inicialmente, foram criados testes simples para verificar a criação do objeto e a pontuação. Em seguida, os testes exigiram a implementação das regras de spare, strike e controle dos frames.

Por fim, foram acrescentados testes para as validações V1, V2 e V3, além de situações de encerramento e jogadas extras no décimo frame.

As refatorações foram realizadas preservando os comportamentos já testados. A execução final da suíte foi realizada com Maven e JUnit.
