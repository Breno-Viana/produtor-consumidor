package Modelo_2;

import java.util.Random;

public class Main {
    private static Buffer<Product> buffer;


    public static void main(String[] args) throws InterruptedException {
        initializeBuffer();
        ProduceAndConsume pac = new ProduceAndConsume(buffer);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                pac.produce();
            }
        }, "producer");
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run () {
                pac.consume();
            }
        }, "consumer");

        consumer.start();
        producer.start();
        consumer.join();
        producer.join();
        System.out.println("Terminado");
    }


    private static void initializeBuffer() {
        System.out.println("Inicializando Buffer...");
        int capacity = new Random().nextInt(100);
        buffer = new Buffer<>(capacity);
        System.out.println("Buffer carregado com a capacidade " + capacity);
    }
}
