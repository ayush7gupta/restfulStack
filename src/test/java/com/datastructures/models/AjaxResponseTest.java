package com.datastructures.models;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class AjaxResponseTest {

    @Test
    public void testSetterResponse()throws NoSuchFieldException, IllegalAccessException{
        final AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        ajaxResponseBody.setResponse("success");

        final Field field = ajaxResponseBody.getClass().getDeclaredField("response");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(ajaxResponseBody), "success");
    }

    @Test
    public void testGetterResponse()throws NoSuchFieldException, IllegalAccessException{
        final AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        final Field field = ajaxResponseBody.getClass().getDeclaredField("response");
        field.setAccessible(true);
        field.set(ajaxResponseBody, "12");

        final String result = ajaxResponseBody.getResponse();

        assertEquals("field wasn't retrieved properly", result, "12");
    }

    @Test
    public void testSetterStack()throws NoSuchFieldException, IllegalAccessException{
        final AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        int[] arr = {1,2};
        ajaxResponseBody.setStack(arr);

        final Field field = ajaxResponseBody.getClass().getDeclaredField("stack");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(ajaxResponseBody), arr);
    }

    @Test
    public void testGetterStack()throws NoSuchFieldException, IllegalAccessException{
        final AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        final Field field = ajaxResponseBody.getClass().getDeclaredField("stack");

        field.setAccessible(true);
        int[] arr = {1,2};
        field.set(ajaxResponseBody, arr);

        final int[] result = ajaxResponseBody.getStack();
        assertEquals("field wasn't retrieved properly", result, arr);
    }
}
