package com.matritellabs.utama.collection;

public class QueueClass implements Queueu{
    private int capacity;
    private Object[] array;

    public QueueClass(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    @Override
    public boolean add(Object e) {
        return false;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public boolean offer(Object e) {
        return false;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object remove() {
        return null;
    }
}
