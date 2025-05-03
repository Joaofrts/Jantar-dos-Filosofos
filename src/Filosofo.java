class Filosofo extends Thread {
    private final Garfo garfoEsquerdo;
    private final Garfo garfoDireito;

    public Filosofo(Garfo garfoEsquerdo, Garfo garfoDireito, String nome) {
        super(nome); // Define nome da Thread
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    private void pensar() throws InterruptedException {
        System.out.println(getName() + " está pensando...");
        Thread.sleep((long) (Math.random() * 1000)); // tempo aleatório
    }

    private void comer() throws InterruptedException {
        System.out.println(getName() + " está comendo ...");
        Thread.sleep((long) (Math.random() * 1000)); // tempo aleatório
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();

                synchronized (garfoEsquerdo) {
                    System.out.println(getName() + " pegou o garfo esquerdo " + garfoEsquerdo.getId());

                    synchronized (garfoDireito) {
                        System.out.println(getName() + " pegou o garfo direito " + garfoDireito.getId());

                        comer();

                        System.out.println(getName() + " largou o garfo direito " + garfoDireito.getId());
                    }

                    System.out.println(getName() + " largou o garfo esquerdo " + garfoEsquerdo.getId());
                }
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " foi interropido!");
            Thread.currentThread().interrupt();
        }
    }
}

