package com.matritellabs.utama.collection;

import java.util.ArrayList;
import java.util.List;

public class QueueClass implements Queueu{
    private int capacity;
    private List<Object> list;

    public QueueClass(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Object e) {
        if (this.list.size() == this.capacity) {
            return false;
        }
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
