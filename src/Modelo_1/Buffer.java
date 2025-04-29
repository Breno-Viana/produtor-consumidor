package Modelo_1;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer<T> {
    private final Queue<T> elements;

    public Buffer(int capacity) {
        elements = new ArrayBlockingQueue<>(capacity);
    }

    public int getSize(){
        return elements.size();
    }

    public Queue<T> getElements() {
        return elements;
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public T removeElement() {
        return elements.remove();
    }

    @Override
    public String toString() {
        return "Modelo_1.Buffer{" +
                "elements=" + elements +
                '}';
    }
}
