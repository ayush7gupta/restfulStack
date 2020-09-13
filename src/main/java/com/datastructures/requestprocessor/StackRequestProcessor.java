package com.datastructures.requestprocessor;

import com.datastructures.models.imp.Stacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StackRequestProcessor {

    @Autowired
    private Stacks stacks;

    public String createStack(int size){
        int resp = stacks.createDataStructure(size);
        if(resp == Integer.MIN_VALUE){
            return "Size of stack cannot be <=0";
        }
        return "Created stack of size " + size;
    }

    public String push(int num){
        int resp = stacks.push(num);
        if(resp == Integer.MIN_VALUE){
            return "Stack is not initialized.";
        }
        else if(resp == Integer.MIN_VALUE+1){
            return "Stack is full. Cannot insert element.";
        }
        return "added " + num + " to the stack.";
    }

    public String pop(){
        int resp = stacks.pop();
        if(resp == Integer.MIN_VALUE){
            return "Stack is not initiated.";
        }
        else if(resp == Integer.MIN_VALUE+1){
            return "Stack is empty.";
        }
        return "The popped element is: " + resp;
    }

    public String peek(){
        int resp = stacks.peek();
        if(resp == Integer.MIN_VALUE){
            return "Stack has not been initiated.";
        }
        else if (resp == Integer.MIN_VALUE+1){
            return "Stack is empty.";
        }
        return "the top most element is: " + resp;
    }

    public int[] getAllElements(){
        return stacks.getAllElements();
    }

    public String reset(){
        boolean resp = stacks.reset();
        if (!resp){
            return "Stack not Initialized";
        }
        return "Stack reset, new size is 0";
    }
}
