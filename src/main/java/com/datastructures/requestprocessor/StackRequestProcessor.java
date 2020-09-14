package com.datastructures.requestprocessor;

import com.datastructures.models.imp.Stacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.datastructures.utils.StackConst.*;

@Component
public class StackRequestProcessor {

    @Autowired
    private Stacks stacks;

    public String createStack(int size){
        int resp = stacks.createDataStructure(size);
        if(resp == Integer.MIN_VALUE){
            return CREATION_FAIL;
        }
        return CREATION_SUCCESS_SIZE + size;
    }

    public String push(int num){
        int resp = stacks.push(num);
        if(resp == Integer.MIN_VALUE){
            return STACK_NOT_INITIALIZED;
        }
        else if(resp == Integer.MIN_VALUE+1){
            return STACK_FULL_PUSH_ERROR;
        }
        return ELEMENT_ADDED + num;
    }

    public String pop(){
        int resp = stacks.pop();
        if(resp == Integer.MIN_VALUE){
            return STACK_NOT_INITIALIZED;
        }
        else if(resp == Integer.MIN_VALUE+1){
            return STACK_IS_EMPTY;
        }
        return POPPED_ELEMENT_IS + resp;
    }

    public String peek(){
        int resp = stacks.peek();
        if(resp == Integer.MIN_VALUE){
            return STACK_NOT_INITIALIZED;
        }
        else if (resp == Integer.MIN_VALUE+1){
            return STACK_IS_EMPTY;
        }
        return THE_TOPMOST_ELEMENT_IS + resp;
    }

    public int[] getAllElements(){
        return stacks.getAllElements();
    }

    public String reset(){
        boolean resp = stacks.reset();
        if (!resp){
            return STACK_NOT_INITIALIZED;
        }
        return STACK_RESET;
    }
}
