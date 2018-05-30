package com.matritellabs.utama.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueClass implements Queueu{
    
    private int capacity;
    private List<Object> list;

    public QueueClass(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Object e) {
        if (this.list.size() >= this.capacity) {
            throw new IllegalStateException();
        }else {
            this.list.add(e);
            return true;
        }
    }

    @Override
    public Object element() {
        if (this.list.size() > 0) {
        return this.list.get(0);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean offer(Object e) {
        if (this.list.size() >= this.capacity) {
            return false;
        }else {
            this.list.add(e);
            return true;
        }
    }

    @Override
    public Object peek() {
        if (this.list.size() > 0) {
            return this.list.get(0);
        }
        else {
            return null;
        }
    }


    @Override
    public Object poll() {
        Object o;
        if (this.list.size() > 0) {
            o = this.list.get(0);
            this.list.remove(0);
            return o;
        }
        else {
            return null;
        }
    }

    @Override
    public Object remove() {
        Object o;
        if (this.list.size() > 0) {
            o = this.list.get(0);
            this.list.remove(0);
            return o;
        }
        else {
            throw new NoSuchElementException();
        }
    }
}
