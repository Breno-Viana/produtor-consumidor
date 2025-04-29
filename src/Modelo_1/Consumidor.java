package Modelo_1;

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
            if (buffer.getBuffer().getSize() > 0) {
               Produto produto = buffer.getBuffer().removeElement();
               System.out.println("Consumidor consumiu " + produto);

           }


        }

    }

    @Override
    public void run() {
        consumir();
    }
}
