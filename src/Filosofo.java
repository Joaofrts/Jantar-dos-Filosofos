class Filosofo extends Thread {
    private final Garfo garfoEsquerdo;
    private final Garfo garfoDireito;
    private Integer vezesComeu = 0;
    private Integer vezesPensou = 0;
    private Integer repeticoes ;

    public Filosofo(Garfo garfoEsquerdo, Garfo garfoDireito, String nome) {
        super(nome);
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
    }

    public Filosofo(Garfo garfoEsquerdo, Garfo garfoDireito, String nome, Integer repeticao) {
        super(nome);
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
        this.repeticoes = repeticao;
    }

    private void pensar() throws InterruptedException {
        System.out.println(getName() + " está pensando...");
        Thread.sleep((long) (Math.random() * 1000));
        vezesPensou++;
    }

    private void comer() throws InterruptedException {
        System.out.println(getName() + " está comendo ...");
        Thread.sleep((long) (Math.random() * 1000));
        vezesComeu++;
    }

    private void relatorio(){
        System.out.println();
        System.out.println(getName() + " comeu "+vezesComeu+" vezes.");
        System.out.println("E pensou "+vezesPensou+" vezes.");
        System.out.println();
    }

    private void executar() throws InterruptedException {
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

    @Override
    public void run() {
        try {
            if(repeticoes != null){
                for (int i = 0; i < repeticoes; i++) {
                    executar();
                }
                relatorio();

            }
            else{
                while (true) {
                    executar();
                }
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " foi interropido!");
            relatorio();
            Thread.currentThread().interrupt();
        }
    }


}

