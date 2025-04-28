public class JantarDosFilosofos {
    public static void main(String[] args) {
        Garfo[] garfos = new Garfo[5];
        for (int i = 0; i < garfos.length; i++) {
            garfos[i] = new Garfo(i);
        }

        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 0; i < filosofos.length; i++) {
            Garfo garfoEsquerdo = garfos[i];
            Garfo garfoDireito = garfos[(i + 1) % garfos.length];

            // Para evitar deadlock:
            if (i == filosofos.length - 1) {
                // O último filósofo pega os garfos na ordem inversa
                filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo, "Filósofo " + (i+1));
            } else {
                filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito, "Filósofo " + (i+1));
            }

            filosofos[i].start();
        }
    }
}

