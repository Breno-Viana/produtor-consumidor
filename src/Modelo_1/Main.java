package Modelo_1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BufferInitializer bf = new BufferInitializer();
        bf.initializer();
        Produtor produtor = new Produtor(bf, "produtor");
        Consumidor consumidor = new Consumidor("consumidor", bf);

        consumidor.start();
        produtor.start();

        consumidor.join();
        produtor.join();


        System.out.println("Terminado");

        //modelo de teste
    }
}
