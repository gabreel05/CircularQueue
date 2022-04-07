package br.com.rpec;

public class CircularQueue {
    private int size;
    private int first;
    private int last;
    private int data[];

    public CircularQueue(int size) {
        this.size = size;
        this.first = -1;
        this.last = -1;
        this.data = new int[size];
    }

    public boolean isFull() {
        if (first == 0 && last == size -1) {
            return true;
        }
        if (first == last + 1) {
            return true;
        }

        return false;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public void add(int element) {
        if (isFull()) {
            throw new IllegalArgumentException("Queue is full");
        } else {
            if (first == -1) {
                first = 0;
                last = (last + 1) % size;
                data[last] = element;
            }
        }
    }

    public int remove() {
        int element;
        if (isEmpty()) {
            return -1;
        } else {
            element = data[first];
            if (first == last) {
                first = -1;
                last = -1;
            } else {
                first = (first + 1) % size;
            }

            return element;
        }
    }
}
