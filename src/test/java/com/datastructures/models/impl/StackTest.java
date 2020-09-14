package com.datastructures.models.impl;

import com.datastructures.models.imp.Stacks;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;


public class StackTest {
    @InjectMocks
    @Spy
    Stacks stack = new Stacks();

    @Test
    public void createSuccessTest(){
        int i = stack.createDataStructure(2);
        assertEquals(i, 2);
    }

    @Test
    public void createStackFailure(){
        int i= stack.createDataStructure(0);
        assertEquals(i, Integer.MIN_VALUE);
    }

    @Test
    public void pushSuccess(){
        stack.createDataStructure(2);
        int i = stack.push(2);
        assertEquals(i, 2);
    }

    @Test
    public void pushFailEmpty(){
        int i = stack.push(9);
        assertEquals(i,Integer.MIN_VALUE);
    }

    @Test
    public void pushFailFull(){
        stack.createDataStructure(2);
        stack.push(1);
        stack.push(2);
        int i= stack.push(3);
        assertEquals(i, Integer.MIN_VALUE+1);
    }

    @Test
    public void popSuccess(){
        stack.createDataStructure(2);
        stack.push(2);
        int i = stack.pop();
        assertEquals(i,2);
    }

    @Test
    public void popFailUninitialized(){
        int i= stack.pop();
        assertEquals(i, Integer.MIN_VALUE);
    }

    @Test
    public void popFailEmpty(){
        stack.createDataStructure(2);
        int i= stack.pop();
        assertEquals(i, Integer.MIN_VALUE+1);
    }

    @Test
    public void peekSuccess(){
        stack.createDataStructure(2);
        stack.push(2);
        int i = stack.peek();
        assertEquals(i,2);
    }

    @Test
    public void peekFailUninitialized(){
        int i= stack.peek();
        assertEquals(i, Integer.MIN_VALUE);
    }

    @Test
    public void peekFailEmpty(){
        stack.createDataStructure(2);
        int i= stack.peek();
        assertEquals(i, Integer.MIN_VALUE+1);
    }

    @Test
    public void resetFail(){
        boolean b = stack.reset();
        assert !b;
    }

    @Test
    public void resetSuccess(){
        stack.createDataStructure(1);
        boolean b = stack.reset();
        assert b;
    }

    @Test
    public void getElementsFailUninitialized(){
        int [] arr = stack.getAllElements();
        assertEquals(arr, null);
    }

    @Test
    public void getElementsEmpty(){
        stack.createDataStructure(2);
        int [] arr = stack.getAllElements();
        assertEquals(arr.length,0);
    }

    @Test
    public void getElemetsSuccess(){
        stack.createDataStructure(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int [] arr = stack.getAllElements();
        assertEquals(arr.length,3);
    }
}
