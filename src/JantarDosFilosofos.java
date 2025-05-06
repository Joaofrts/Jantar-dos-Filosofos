import java.util.InputMismatchException;
import java.util.Scanner;

public class JantarDosFilosofos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jantar dos Filósofos!");
        System.out.print("Deseja rodadas limitadas? (s/n): ");
        String escolha = scanner.nextLine().trim().toLowerCase();

        boolean rodadasLimitadas = escolha.equals("s");
        int repeticoes = 0;

        if (rodadasLimitadas) {
            System.out.print("Quantas rodadas cada filósofo deve executar? ");
            while (true) {
                try {
                    repeticoes = scanner.nextInt();
                    scanner.nextLine();
                    if (repeticoes > 0) {
                        break;
                    } else {
                        System.out.print("Digite um número inteiro positivo: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Entrada inválida. Digite um número inteiro: ");
                    scanner.nextLine();
                }
            }
        }


        Garfo[] garfos = new Garfo[5];
        for (int i = 0; i < garfos.length; i++) {
            garfos[i] = new Garfo(i);
        }


        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 0; i < filosofos.length; i++) {
            Garfo garfoEsquerdo = garfos[i];
            Garfo garfoDireito = garfos[(i + 1) % garfos.length];

            if (rodadasLimitadas) {

                if (i == filosofos.length - 1) {
                    filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo, "Filósofo " + (i + 1), repeticoes);
                } else {
                    filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito, "Filósofo " + (i + 1), repeticoes);
                }
            } else {

                if (i == filosofos.length - 1) {
                    filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo, "Filósofo " + (i + 1));
                } else {
                    filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito, "Filósofo " + (i + 1));
                }
            }

            filosofos[i].start();
        }

        if (rodadasLimitadas) {
            for (Filosofo filosofo : filosofos) {
                try {
                    filosofo.join();
                } catch (InterruptedException e) {
                    System.out.println("Main foi interrompida enquanto esperava os filósofos.");
                }
            }
            System.out.println("Todos os filósofos terminaram suas rodadas!");
        } else {
            System.out.println("Os filósofos estão rodando infinitamente.");
        }

        scanner.close();
    }
}


