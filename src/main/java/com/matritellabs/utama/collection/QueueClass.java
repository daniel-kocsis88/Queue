package com.matritellabs.utama.collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueClass implements Queueu{

    private int capacity;
    private List<Object> list;
    static Logger logger = LoggerFactory.getLogger(QueueClass.class);

    public QueueClass(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Object e) {
        if (this.list.size() >= this.capacity) {
            logger.error("IllegalStateException" + new IllegalStateException());
            throw new IllegalStateException();
        }else {
            this.list.add(e);
            logger.info("element added successfully " + e);
            return true;
        }
    }

    @Override
    public Object element() {
        if (this.list.size() > 0) {
            logger.info("element retreived successfully " + this.list.get(0));
        return this.list.get(0);
        }
        else {
            logger.error("NoSuchElementException" + new NoSuchElementException());
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean offer(Object e) {
        if (this.list.size() >= this.capacity) {
            logger.info("element couldnt be added to the queue   " + e);
            return false;
        }else {
            this.list.add(e);
            logger.info("element added successfully " + e);
            return true;
        }
    }

    @Override
    public Object peek() {
        if (this.list.size() > 0) {
            logger.info("element retrieved " + this.list.get(0));
            return this.list.get(0);
        }
        else {
            logger.info("no element in the queue" );
            return null;
        }
    }


    @Override
    public Object poll() {
        Object o;
        if (this.list.size() > 0) {
            o = this.list.get(0);
            this.list.remove(0);
            logger.info("element retrieved, and removed " + o);
            return o;
        }
        else {
            logger.info("no element to remove");
            return null;
        }
    }

    @Override
    public Object remove() {
        Object o;
        if (this.list.size() > 0) {
            o = this.list.get(0);
            this.list.remove(0);
            logger.info("element retrieved, and removed " + o);
            return o;
        }
        else {
            logger.error("No such element to remove " + new NoSuchElementException());
            throw new NoSuchElementException();
        }
    }
}
