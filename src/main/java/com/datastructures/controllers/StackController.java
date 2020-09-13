package com.datastructures.controllers;

import com.datastructures.models.AjaxResponseBody;
import com.datastructures.models.InputCriteria;
import com.datastructures.requestprocessor.StackRequestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class StackController {
    private static final Logger log = LoggerFactory.getLogger(StackController.class);
    private static final String BASE_URL = "/stack/";

    @Autowired
    private StackRequestProcessor stackRequestProcessor;

    @PostMapping(value = BASE_URL +"create")
    public ResponseEntity<?> createStack(@RequestBody InputCriteria inputCriteria, Errors errors){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        int num = 0;
        try{
             num = Integer.parseInt(inputCriteria.getNum());
        }
        catch (Exception e){
            ajaxResponseBody.setResponse("Please enter an int");
            ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
            return ResponseEntity.ok(ajaxResponseBody);
        }

        String resp = stackRequestProcessor.createStack(num);
        ajaxResponseBody.setResponse(resp);
        ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
        return ResponseEntity.ok(ajaxResponseBody);
    }

    @PostMapping(value = BASE_URL + "push")
    public ResponseEntity<?> pushToStack(@RequestBody InputCriteria inputCriteria, Errors errors){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        int num = 0;
        try{
            num = Integer.parseInt(inputCriteria.getNum());
        }
        catch (Exception e){
            ajaxResponseBody.setResponse("Please enter an int");
            ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
            return ResponseEntity.ok(ajaxResponseBody);
        }
        String resp = stackRequestProcessor.push(num);
        ajaxResponseBody.setResponse(resp);
        ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
        return ResponseEntity.ok(ajaxResponseBody);
    }

    @GetMapping(value = BASE_URL + "peek")
    public ResponseEntity<?> getTop(){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        String resp = stackRequestProcessor.peek();
        ajaxResponseBody.setResponse(resp);
        ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
        return ResponseEntity.ok(ajaxResponseBody);
    }

    @DeleteMapping(value = BASE_URL + "pop")
    public ResponseEntity<?> removeTop(){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        String resp = stackRequestProcessor.pop();
        ajaxResponseBody.setResponse(resp);
        ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
        return ResponseEntity.ok(ajaxResponseBody);
    }

    @GetMapping(value = BASE_URL + "reset")
    public ResponseEntity<?> resetStack(){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        String resp = stackRequestProcessor.reset();
        ajaxResponseBody.setResponse(resp);
        ajaxResponseBody.setStack(stackRequestProcessor.getAllElements());
        return ResponseEntity.ok(ajaxResponseBody);
    }


}
