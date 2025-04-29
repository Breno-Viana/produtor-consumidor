

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
        return "Produto{" + "size=" + size+ '}';
    }
}

