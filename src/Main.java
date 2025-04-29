

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BufferInitializer am = new BufferInitializer();
        am.initializer();
        Produtor produtor = new Produtor(am, "jiao");

        produtor.start();
        produtor.join();

        System.out.println("Terminado");
    }
}
