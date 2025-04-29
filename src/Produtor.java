

import java.util.Random;

public class Produtor extends Thread {
    private String name;
    private final BufferInitializer am;
    private boolean running = true;
    private Produto p;

    public Produtor(BufferInitializer am, String name) {
        super(am, name);
        this.am = am;
        this.name = name;

    }

    void produzir() {
        while (running) {
            synchronized (am) {
                if (am.getBuffer().getSize() == am.getBufferLimit()) {
                    System.out.println(Thread.currentThread().getName() + " PAROOOOU");
                   // System.out.println(am.getBuffer().getSize());
                    try {
                        am.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                p = new Produto(new Random().nextInt());
                am.getBuffer().addElement(p);
                System.out.println(Thread.currentThread().getName() + " Produziu o produto -> "+p);
                am.notify();
            }

        }
    }

    public void run() {
        for (int i = 0; i <= am.getBufferLimit() - 1; i++) {
            produzir();
        }
        am.run();

    }

}
