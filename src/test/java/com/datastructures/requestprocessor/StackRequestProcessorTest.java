package com.datastructures.requestprocessor;

import com.datastructures.models.imp.Stacks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static com.datastructures.utils.StackConst.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StackRequestProcessorTest {

    @Mock
    Stacks stack;

    @InjectMocks
    @Spy
    StackRequestProcessor stackRequestProcessor = new StackRequestProcessor();

    @Test
    public void createStackFail(){

        when(stack.createDataStructure(anyInt())).thenReturn(Integer.MIN_VALUE);
        String resp = stackRequestProcessor.createStack(-1);
        System.out.println("Response is " + resp);
        assertEquals(resp, CREATION_FAIL);
    }

    @Test
    public void createStackSuccess(){
        int i = 2;
        when(stack.createDataStructure(anyInt())).thenReturn(i);
        String resp = stackRequestProcessor.createStack(i);
        System.out.println("Response is " + resp);
        assertEquals(resp, CREATION_SUCCESS_SIZE +i);
    }

    @Test
    public void pushFailUninitialized(){
        when(stack.push(anyInt())).thenReturn(Integer.MIN_VALUE);
        String resp = stackRequestProcessor.push(2);
        assertEquals(resp, STACK_NOT_INITIALIZED);
    }

    @Test
    public void pushFailFull(){
        when(stack.push(anyInt())).thenReturn(Integer.MIN_VALUE+1);
        String resp = stackRequestProcessor.push(2);
        assertEquals(resp, STACK_FULL_PUSH_ERROR);
    }

    @Test
    public void pushSuccess(){
        int i = 2;
        when(stack.push(i)).thenReturn(i);
        String resp = stackRequestProcessor.push(i);
        assertEquals(resp, ELEMENT_ADDED + i);
    }

    @Test
    public void popFailUninitialized(){
        when(stack.pop()).thenReturn(Integer.MIN_VALUE);
        String resp = stackRequestProcessor.pop();
        assertEquals(resp, STACK_NOT_INITIALIZED);
    }

    @Test
    public void popFailEmpty(){
        when(stack.pop()).thenReturn(Integer.MIN_VALUE+1);
        String resp = stackRequestProcessor.pop();
        assertEquals(resp, STACK_IS_EMPTY);
    }

    @Test
    public void popSuccess(){
        int i = 2;
        when(stack.pop()).thenReturn(i);
        String resp = stackRequestProcessor.pop();
        assertEquals(resp, POPPED_ELEMENT_IS + i);

    }

    @Test
    public void peekFailUninitialized(){
        when(stack.peek()).thenReturn(Integer.MIN_VALUE);
        String resp = stackRequestProcessor.peek();
        assertEquals(resp, STACK_NOT_INITIALIZED);
    }

    @Test
    public void peekFailEmpty(){
        when(stack.peek()).thenReturn(Integer.MIN_VALUE+1);
        String resp = stackRequestProcessor.peek();
        assertEquals(resp, STACK_IS_EMPTY);
    }

    @Test
    public void peekSuccess(){
        int i = 2;
        when(stack.peek()).thenReturn(i);
        String resp = stackRequestProcessor.peek();
        assertEquals(resp, THE_TOPMOST_ELEMENT_IS + i);
    }

    @Test
    public void resetFail(){
        when(stack.reset()).thenReturn(false);
        String resp = stackRequestProcessor.reset();
        assertEquals(resp, STACK_NOT_INITIALIZED);
    }

    @Test
    public void resetSuccess(){
        when(stack.reset()).thenReturn(true);
        String resp = stackRequestProcessor.reset();
        assertEquals(resp, STACK_RESET);

    }

}
