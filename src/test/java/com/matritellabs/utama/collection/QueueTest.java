package com.matritellabs.utama.collection;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class QueueTest {

    @Test
    public void testAddString() {
        QueueClass qc = new QueueClass(10);
        assertEquals(true, qc.add("sheep"));
        assertEquals(true, qc.add("giraffe"));
        assertEquals(true, qc.add("sloth"));
        assertEquals(true, qc.add("tamandua"));
        assertEquals(true, qc.add("raccoon"));
        assertEquals(true, qc.add("hamster"));
        assertEquals(true, qc.add("horse"));
        assertEquals(true, qc.add("rat"));
        assertEquals(true, qc.add("m"));
        assertEquals(true, qc.add("rat"));
    }


}
