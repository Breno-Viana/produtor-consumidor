package Modelo_2;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer<T> {
    private Queue<T> buffer;
    private int capacity;

    public Buffer(int maxCapacity) {
        buffer = new ArrayBlockingQueue<>(maxCapacity);
        capacity = maxCapacity;
    }

    public Queue<T> getBuffer() {
        return buffer;
    }

    public int getCapacity() {
        return capacity;
    }
}
