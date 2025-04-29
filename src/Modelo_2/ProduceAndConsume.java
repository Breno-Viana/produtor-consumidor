package Modelo_2;

import java.util.Random;

public class ProduceAndConsume {
    private final Buffer<Product> buffer;
    private final Random random;

    public ProduceAndConsume(Buffer<Product> buffer) {
        this.buffer = buffer;
        this.random = new Random();
    }

    public void produce() {
        while (true) {
            synchronized (this) {
                while (buffer.getBuffer().size() == buffer.getCapacity()) {
                    try {
                        System.out.println("Fila cheia, produtor esperando");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (buffer.getBuffer().isEmpty()) {
                    Product product = new Product(random.nextInt());
                    buffer.getBuffer().add(product);
                    System.out.println("Produzido: " + product);
                    notify();
                    System.out.println("Consumidor notificado");
                }

            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                if (buffer.getBuffer().isEmpty()) {
                    try {
                        System.out.println("Fila vazia, consumidor esperando");
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("consumidor consumiu: " + buffer.getBuffer().remove());
                System.out.println("Produtor notificado");
                notify();

            }
        }
    }
}