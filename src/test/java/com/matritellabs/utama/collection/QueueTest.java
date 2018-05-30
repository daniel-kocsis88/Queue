package com.matritellabs.utama.collection;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

class Animal{

    protected String name;
    protected double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
}

public class QueueTest {

    @Test
    public void testAddIntegersAllTrue() {
        QueueClass qc = new QueueClass(5);
        assertTrue(qc.add(9));
        assertTrue(qc.add(20));
        assertTrue(qc.add(27));
        assertTrue(qc.add(23));
        assertTrue(qc.add(47));
    }

    @Test
    public void testAddIntegersOneFalse(){
        QueueClass qc = new QueueClass(3);
        assertTrue(qc.add(9));
        assertTrue(qc.add(20));
        assertTrue(qc.add(27));
        assertEquals(new IllegalStateException(), qc.add(75));
    }

    @Test
    public void testAddStringAllTrue() {
        QueueClass qc = new QueueClass(4);
        assertTrue(qc.add("sheep"));
        assertTrue(qc.add("giraffe"));
        assertTrue(qc.add("sloth"));
        assertTrue(qc.add("tamandua"));
    }

    @Test
    public void testAddStringOneFalse(){
        QueueClass qc = new QueueClass(5);
        assertTrue(qc.add("sheep"));
        assertTrue(qc.add("giraffe"));
        assertTrue(qc.add("sloth"));
        assertTrue(qc.add("tamandua"));
        assertEquals(new IllegalStateException(), qc.add("lizard"));
    }

    @Test
    public void testAddObjectsAllTrue() {

        QueueClass qc = new QueueClass(6);
        assertTrue(qc.add(new Animal("sheep - ram", 53.4d)));
        assertTrue(qc.add(new Animal("sheep - ewe", 53.4d)));
        assertTrue(qc.add(new Animal("giraffe - male", 1129.5d)));
        assertTrue(qc.add(new Animal("giraffe - female", 890.5d)));
        assertTrue(qc.add(new Animal("sloth - male", 6.3d)));
        assertTrue(qc.add(new Animal("sloth - female", 5.1d)));
    }

    @Test
    public void testAddObjectsOneFalse() {

        QueueClass qc = new QueueClass(6);
        assertTrue(qc.add(new Animal("sheep - ram", 53.4d)));
        assertTrue(qc.add(new Animal("sheep - ewe", 53.4d)));
        assertTrue(qc.add(new Animal("giraffe - male", 1129.5d)));
        assertTrue(qc.add(new Animal("giraffe - female", 890.5d)));
        assertTrue(qc.add(new Animal("sloth - male", 6.3d)));
        assertTrue(qc.add(new Animal("sloth - female", 5.1d)));;
        assertEquals(new IllegalStateException(), qc.add(new Animal("hamster - male", 0.15d)));
    }

    @Test
    public void testAddMixedObjectsAllTrue() {

        QueueClass qc = new QueueClass(3);
        assertTrue(qc.add(9));
        assertTrue(qc.add("sheep"));
        assertTrue(qc.add(new Animal("giraffe - male", 1129.5d)));
    }

    @Test
    public void testAddMixedObjectsOneFalse() {

        QueueClass qc = new QueueClass(3);
        assertTrue(qc.add(9));
        assertTrue(qc.add("sheep"));
        assertTrue(qc.add(new Animal("giraffe - male", 1129.5d)));
        assertEquals(new IllegalStateException(), qc.add(new Animal("hamster - male", 0.15d)));
    }

}
