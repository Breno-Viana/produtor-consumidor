public class Consumidor extends Thread {
    private String name;
    private final BufferInitializer buffer;

    public Consumidor(String name, BufferInitializer buffer) {
        super(buffer, name);
        this.name = name;
        this.buffer = buffer;
    }


    void consumir() {
        synchronized (buffer) {
            if (buffer.getBuffer().isEmpty()) {
                while (buffer.getBuffer().isEmpty()) {
                    try {
                        buffer.wait();
                        buffer.notify();po
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    @Override
    public void run() {

    }
}
