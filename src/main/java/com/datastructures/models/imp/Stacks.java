package com.datastructures.models.imp;

import com.datastructures.models.BaseDataStructure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class Stacks implements BaseDataStructure {

    private int size =-1;
    private int top =0;
    private int[] arr =null;
    private static final Logger log = LoggerFactory.getLogger(Stacks.class);


    public static void main(String [] args){
        Stacks stacks = new Stacks();
        log.info(stacks.createDataStructure(5) + "");
        log.info("" + stacks.push(2));
        log.info("" + stacks.push(3));
        log.info("" + stacks.push(4));
        log.info("" + stacks.pop());
        log.info("" + stacks.pop());
        log.info("" + stacks.peek());
        log.info("" + stacks.pop());
        log.info("" + stacks.pop());
        log.info("" + stacks.push(28));
        log.info("" + stacks.push(25));
        log.info(stacks.createDataStructure(-2) + "");
        log.info("" + stacks.pop());


    }

    @Override
    public int createDataStructure(int i){
        if(i <= 0){
            top = 0;
            size =-1;
            return Integer.MIN_VALUE;
        }
        arr = new int[i];
        size = i;
        top = -1;
        return i;
    }

    @Override
    public int push(int i){
        if(size == -1 || arr == null){
            return Integer.MIN_VALUE;
        }
        if(top == size-1){
            return Integer.MIN_VALUE +1;
        }
        arr[++top] = i;
        return arr[top];
    }

    @Override
    public int pop(){
        if (arr == null || size == -1){
            return Integer.MIN_VALUE;
        }
        if(top ==-1){
            return Integer.MIN_VALUE+1;
        }
        return arr[top--];
    }

    @Override
    public int peek(){
        if(size == -1 || arr == null ){
            return Integer.MIN_VALUE;
        }
        if(top == -1){
            return Integer.MIN_VALUE+1;
        }
        return arr[top];
    }

    @Override
    public int[] getAllElements(){
        if(size ==-1 || arr==null){
            return null;
        }
        else if(top ==-1){
            return new int[0];
        }
        int[] stack = new int[top+1];
        for(int i = top, j =0; i >= 0; i--, j++){
            stack[j] = arr[i];
        }
        return stack;
    }

    @Override
    public boolean reset(){
        if(size ==-1 || arr==null){
            return false;
        }
        top =-1;
        return true;
    }
}
