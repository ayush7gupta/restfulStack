package com.datastructures.controllers;

import com.datastructures.models.AjaxResponseBody;
import com.datastructures.models.InputCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(
            @RequestBody InputCriteria inputCriteria, Errors errors){
        AjaxResponseBody result = new AjaxResponseBody();
        System.out.println(inputCriteria);

        try{
            int num = Integer.parseInt(inputCriteria.getNum());
            result.setResponse("success and num is " + num);
        }
        catch (Exception e){
            result.setResponse("Please enter an int");
        }

        int []arr = new int[3];
        arr[0]=2;
        arr[1]=3;
        arr[2]=4;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        result.setStack(arr);
        return ResponseEntity.ok(result);

    }

    @DeleteMapping("/api/search2")
    public ResponseEntity<?> getSearchResultViaAjax2(){
        AjaxResponseBody result = new AjaxResponseBody();

        result.setResponse("success for pop");
        int []arr = new int[3];
        arr[0]=2;
        arr[1]=3;
        arr[2]=4;
        result.setStack(arr);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/api/search3")
    public ResponseEntity<?> getSearchResultViaAjax3(){
        AjaxResponseBody result = new AjaxResponseBody();

        result.setResponse("success for peek");
        int []arr = new int[3];
        arr[0]=2;
        arr[1]=3;
        arr[2]=4;
        result.setStack(arr);
        return ResponseEntity.ok(result);

    }
}
