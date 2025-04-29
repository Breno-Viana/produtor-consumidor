import java.util.Random;

public class BufferInitializer implements Runnable {
    private final Random rand = new Random();
    private Buffer<Produto> BUFFER;
    private final int bufferLimit = rand.nextInt(101);


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + BUFFER.getSize());
    }

    public Buffer<Produto> getBuffer() {
        return BUFFER;
    }

    public void initializer() {
        System.out.println("Iniciando BufferInitializer");
        BUFFER = new Buffer<>(bufferLimit);
        System.out.println("Limite do Buffer: " + bufferLimit);
    }


    int getBufferLimit() {
        return bufferLimit;
    }

}
