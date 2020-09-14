package com.datastructures.models;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class InputCriteriaTest {

    @Test
    public void testSetter()throws NoSuchFieldException, IllegalAccessException{
        final InputCriteria inputCriteria = new InputCriteria();
        inputCriteria.setNum("12");

        final Field field = inputCriteria.getClass().getDeclaredField("num");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(inputCriteria), "12");
    }

    @Test
    public void testGetter() throws NoSuchFieldException, IllegalAccessException{
        final InputCriteria inputCriteria = new InputCriteria();
        final Field field = inputCriteria.getClass().getDeclaredField("num");
        field.setAccessible(true);
        field.set(inputCriteria, "12");

        final String result = inputCriteria.getNum();

        assertEquals("field wasn't retrieved properly", result, "12");

    }
}
