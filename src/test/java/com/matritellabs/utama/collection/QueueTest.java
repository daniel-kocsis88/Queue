package com.matritellabs.utama.collection;

import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
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
//-------------------------------------------------ADD-----------------------------------------------
    @Test
    public void testAddIntegersAllTrue() {
        QueueClass qc = new QueueClass(5);
        assertTrue(qc.add(9));
        assertTrue(qc.add(20));
        assertTrue(qc.add(27));
        assertTrue(qc.add(23));
        assertTrue(qc.add(47));
    }

    @Test(expected = IllegalStateException.class)
    public void testAddIntegersOneFalse(){
        QueueClass qc = new QueueClass(3);
        qc.add(9);
        qc.add(20);
        qc.add(27);
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

    @Test (expected = IllegalStateException.class)
    public void testAddStringOneFalse(){
        QueueClass qc = new QueueClass(4);
        qc.add("sheep");
        qc.add("giraffe");
        qc.add("sloth");
        qc.add("tamandua");
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
    public void testAddSameObjectsAllTrue() {

        Animal a = new Animal("sheep - ram", 53.4d);
        QueueClass qc = new QueueClass(4);
        assertTrue(qc.add(a));
        assertTrue(qc.add(a));
        assertTrue(qc.add(a));
        assertTrue(qc.add(a));
    }

    @Test (expected = IllegalStateException.class)
    public void testAddObjectsOneFalse() {

        QueueClass qc = new QueueClass(6);
        qc.add(new Animal("sheep - ram", 53.4d));
        qc.add(new Animal("sheep - ewe", 53.4d));
        qc.add(new Animal("giraffe - male", 1129.5d));
        qc.add(new Animal("giraffe - female", 890.5d));
        qc.add(new Animal("sloth - male", 6.3d));
        qc.add(new Animal("sloth - female", 5.1d));
        assertEquals(new IllegalStateException(), qc.add(new Animal("hamster - male", 0.15d)));
    }

    @Test
    public void testAddMixedObjectsAllTrue() {

        QueueClass qc = new QueueClass(3);
        assertTrue(qc.add(9));
        assertTrue(qc.add("sheep"));
        assertTrue(qc.add(new Animal("giraffe - male", 1129.5d)));
    }

    @Test (expected = IllegalStateException.class)
    public void testAddMixedObjectsOneFalse() {

        QueueClass qc = new QueueClass(3);
        qc.add(9);
        qc.add("sheep");
        qc.add(new Animal("giraffe - male", 1129.5d));
        assertEquals(new IllegalStateException(), qc.add(new Animal("hamster - male", 0.15d)));
    }
    //-------------------------------------------------ELEMENT------------------------------------------
    @Test
    public void testElementIntegersTrue() {
        QueueClass qc = new QueueClass(5);
        qc.add(9);
        qc.add(17);
        qc.add(37);
        assertEquals(9, qc.element());
    }

    @Test (expected = NoSuchElementException.class)
    public void testElementIntegersNull() {
        QueueClass qc = new QueueClass(5);
        assertEquals(new NoSuchElementException(), qc.element());
    }

    @Test
    public void testElementMixedTrue() {
        QueueClass qc = new QueueClass(5);
        qc.add(9);
        qc.add("Sheep");
        qc.add(new Animal("sheep - ram", 53.4d));
        assertEquals(9, qc.element());
    }

    @Test (expected = NoSuchElementException.class)
    public void testElementMixedFalse() {
        QueueClass qc = new QueueClass(5);
        qc.add(9);
        qc.remove();
        assertEquals(new NoSuchElementException(), qc.element());
    }

    @Test (expected = NoSuchElementException.class)
    public void testElementMixedFalseSecond() {
        QueueClass qc = new QueueClass(3);
        qc.add(9);
        qc.add("Sheep");
        qc.add(new Animal("sheep - ram", 53.4d));
        qc.remove();
        qc.remove();
        qc.remove();
        assertEquals(new NoSuchElementException(), qc.element());
    }

    @Test
    public void testElementMixedTrueSecond() {
        QueueClass qc = new QueueClass(5);
        qc.add("Sheep");
        qc.add(new Animal("sheep - ram", 53.4d));
        qc.add(9);
        qc.remove();
        qc.remove();
        assertEquals(9, qc.element());
    }
//-------------------------------------------------OFFER------------------------------------------

    @Test
    public void testOfferIntegerTrue() {
        QueueClass qc = new QueueClass(3);
        assertTrue(qc.offer(10));
        assertTrue(qc.offer(15));
        assertTrue(qc.offer(19));
    }

    @Test
    public void testOfferIntegerFalse() {
        QueueClass qc = new QueueClass(5);
        qc.offer(10);
        qc.offer(17);
        qc.offer(6);
        qc.offer(69);
        qc.offer(35);
        assertFalse(qc.offer(19));
    }

    @Test
    public void testOfferStringTrue() {
        QueueClass qc = new QueueClass(3);
        assertTrue(qc.offer("sheep"));
        assertTrue(qc.offer("giraffe"));
        assertTrue(qc.offer("sloth"));
    }

    @Test
    public void testOfferStringFalse() {
        QueueClass qc = new QueueClass(3);
        qc.add("sheep");
        qc.add("giraffe");
        qc.add("sloth");
        assertFalse(qc.offer("tamandua"));
    }

    @Test
    public void testOfferMixedTrue() {
        QueueClass qc = new QueueClass(3);
        assertTrue(qc.offer(85));
        assertTrue(qc.offer("giraffe"));
        assertTrue(qc.offer(new Animal("giraffe - male", 1129.5d)));
    }

    @Test
    public void testOfferMixedFalse() {
        QueueClass qc = new QueueClass(3);
        qc.add(85);
        qc.add("giraffe");
        qc.add(new Animal("giraffe - male", 1129.5d));
        assertFalse(qc.offer("tamandua"));
    }
//-------------------------------------------------PEEK------------------------------------------

    @Test
    public void testPeekIntegerTrue() {
        QueueClass qc = new QueueClass(3);
        qc.add(85);
        qc.add(69);
        qc.add(460);
        assertEquals(85, qc.peek());
    }

    @Test
    public void testPeekIntegerFalse() {
        QueueClass qc = new QueueClass(3);
        assertEquals(null, qc.peek());
    }

    @Test
    public void testPeekIntegerTrueSecond() {
        QueueClass qc = new QueueClass(3);
        qc.add(85);
        qc.add(69);
        qc.add(460);
        qc.remove();
        qc.remove();
        assertEquals(460, qc.peek());
    }

    @Test
    public void testPeekIntegerFalseSecond() {
        QueueClass qc = new QueueClass(3);
        qc.add(69);
        qc.add(460);
        qc.remove();
        qc.remove();
        assertEquals(null, qc.peek());
    }

    @Test
    public void testPeekStringTrue() {
        QueueClass qc = new QueueClass(3);
        qc.add("giraffe");
        qc.add("sloth");
        qc.add("sheep");
        qc.remove();
        qc.remove();
        assertEquals("sheep", qc.peek());
    }

    @Test
    public void testPeekMixTrue() {
        QueueClass qc = new QueueClass(3);
        Animal a = new Animal("giraffe - male", 1129.5d);
        qc.add(60);
        qc.add("sloth");
        qc.add(a);
        qc.remove();
        qc.remove();
        assertEquals(a, qc.peek());
    }

    //-------------------------------------------------POLL------------------------------------------

    @Test
    public void testPollIntegerTrue() {

        QueueClass qc = new QueueClass(3);
        qc.add(69);
        qc.add(460);
        qc.remove();
        assertEquals(460, qc.poll());
    }

    @Test
    public void testPollIntegerFalse() {

        QueueClass qc = new QueueClass(3);
        qc.add(69);
        qc.add(460);
        qc.remove();
        qc.remove();
        assertEquals(null, qc.poll());
    }

    @Test
    public void testPollIntegerFalseSecond() {

        QueueClass qc = new QueueClass(3);
        qc.add(69);
        qc.add(460);
        qc.remove();
        assertEquals(460, qc.poll());
        assertEquals(null, qc.poll());
    }

    @Test
    public void testPollMixTrue() {

        QueueClass qc = new QueueClass(3);
        Animal a = new Animal("giraffe - male", 1129.5d);
        qc.add(69);
        qc.add("giraffe");
        qc.add(a);
        qc.remove();
        qc.remove();
        assertEquals(a, qc.poll());
    }

    @Test
    public void testPollMixFalse() {

        QueueClass qc = new QueueClass(3);
        Animal a = new Animal("giraffe - male", 1129.5d);
        qc.add(69);
        qc.add("giraffe");
        qc.add(a);
        qc.poll();
        qc.poll();
        qc.poll();
        assertEquals(null, qc.poll());
    }

    //-------------------------------------------------REMOVE------------------------------------------
    @Test
    public void testReturnIntegerTrue() {

        QueueClass qc = new QueueClass(3);
        qc.add(69);
        qc.add(460);
        assertEquals(69, qc.remove());
        assertEquals(460, qc.remove());
    }

    @Test (expected = NoSuchElementException.class)
    public void testReturnIntegerFalse() {

        QueueClass qc = new QueueClass(3);
        qc.add(69);
        qc.add(460);
        qc.remove();
        qc.remove();
        assertEquals(new NoSuchElementException(), qc.remove());
    }

    @Test
    public void testReturnMixTrue() {

        QueueClass qc = new QueueClass(3);
        Animal a = new Animal("giraffe - male", 1129.5d);
        qc.add(69);
        qc.add("sloth");
        qc.add(a);
        assertEquals(69, qc.remove());
        assertEquals("sloth", qc.remove());
        assertEquals(a, qc.remove());
    }

    @Test (expected = NoSuchElementException.class)
    public void testReturnMixFalse() {

        QueueClass qc = new QueueClass(3);
        Animal a = new Animal("giraffe - male", 1129.5d);
        qc.add(69);
        qc.add("sloth");
        qc.add(a);
        qc.remove();
        qc.remove();
        qc.remove();
        assertEquals(new NoSuchElementException(), qc.remove());
    }

}
