# Desafio dos Filósofos Jantando - Solução em Java

## 📚 Sobre o Desafio

O **Problema dos Filósofos Jantando** é um clássico problema de sincronização e concorrência em sistemas com múltiplas threads. Este problema envolve um número fixo de filósofos sentados ao redor de uma mesa. Cada filósofo precisa de dois garfos para comer, mas cada garfo está compartilhado entre dois filósofos. O desafio é garantir que todos os filósofos possam comer sem entrar em um estado de deadlock ou starvation.

## 🚀 Objetivo

O objetivo é implementar uma solução utilizando Java para simular os filósofos jantando, garantindo que eles possam alternar entre pensar e comer, e que a sincronização dos garfos seja feita corretamente para evitar problemas de concorrência como o deadlock.

## 🔧 Tecnologias Utilizadas

- **Java**: Para implementar a solução utilizando threads e sincronização.
- **Threads**: Utilizadas para simular os filósofos como processos concorrentes.
- **`synchronized`**: Usado para garantir que apenas um filósofo possa pegar um garfo de cada vez.
- **`Thread.currentThread().interrupt()`**: Para interromper as threads dos filósofos de maneira controlada.

## 🛠 Estrutura do Projeto

O projeto é composto por três classes principais:

1. **Garfo**: Representa um garfo que os filósofos usam para comer. Cada garfo é compartilhado entre dois filósofos e é protegido por um bloqueio para garantir que um filósofo não tente pegar o garfo enquanto outro já o estiver usando.

2. **Filosofo**: Representa um filósofo. Cada filósofo pode pensar, comer e pegar garfos. A implementação utiliza threads, onde cada filósofo é uma thread executando continuamente em busca de comer.

3. **JantarDosFilosofos**: Controla o ciclo de vida dos filósofos e dos garfos. Inicializa os filósofos, faz com que eles comecem a pensar e comer, e gera um relatório com o número de vezes que cada filósofo comeu, o tempo gasto comendo e o tempo esperando pelos garfos.

## 📝 Como Funciona?

O processo de jantar dos filósofos segue os seguintes passos:

1. **Pensamento**: Cada filósofo passa um tempo pensando antes de tentar comer.
2. **Pegar Garfos**: O filósofo precisa pegar os dois garfos (um à esquerda e outro à direita). A sincronização é garantida usando `synchronized`, o que impede que dois filósofos peguem o mesmo garfo ao mesmo tempo.
3. **Comer**: Depois de pegar os dois garfos, o filósofo começa a comer.
4. **Soltar Garfos**: Após terminar de comer, o filósofo solta os garfos e o processo se repete.

A implementação assegura que os filósofos alternem entre pensar e comer, sem causar deadlock ou starvation, utilizando uma abordagem simples de sincronização.
