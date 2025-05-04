public class Main {
    private static Buffer<Product> buffer;
    private static int CAPACITY;


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
            public void run() {
                pac.consume();
            }
        }, "consumer");

        consumer.start();
        producer.start();
    }


    private static void initializeBuffer() {
        System.out.println("Inicializando Buffer...");
        CAPACITY = 10;
        buffer = new Buffer<>(CAPACITY);
        System.out.println("Buffer carregado com a capacidade " + CAPACITY);
    }
}
