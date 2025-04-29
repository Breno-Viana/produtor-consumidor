package Modelo_1;

public class Produto {
    private int size;

    public Produto(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Modelo_1.Produto{" + "size=" + size+ '}';
    }
}

