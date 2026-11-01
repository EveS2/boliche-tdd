# Plano de testes — Jogo de Boliche

## Objetivo
Implementar a classe Jogo utilizando TDD, conforme demonstrado por Uncle Bob.

## Testes planejados

- [ ] Verificar a configuração do JUnit.
- [ ] Criar uma instância de Jogo.
- [ ] Verificar a pontuação inicial.
- [ ] Partida sem derrubar pinos: 0 pontos.
- [ ] Partida com um pino por jogada: 20 pontos.
- [ ] Partida com um spare: 16 pontos.
- [ ] Partida com um strike: 24 pontos.
- [ ] Todos os frames com spare: 150 pontos.
- [ ] Jogo perfeito: 300 pontos.
- [ ] Partida mista: 167 pontos.
- [ ] V1: rejeitar jogadas negativas.
- [ ] V1: rejeitar jogadas maiores que 10.
- [ ] V2: rejeitar segunda jogada que ultrapasse 10 pinos.
- [ ] V3: rejeitar jogadas após o encerramento.
- [ ] Verificar encerramento após décimo frame aberto.
- [ ] Verificar encerramento após bônus de spare.
- [ ] Verificar encerramento após bônus de strike.

## Metodologia

Cada comportamento será desenvolvido em ciclos RED, GREEN e REFACTOR.

Os testes serão executados com `mvn test`, e cada fase terá um commit próprio no Git.
