package com.datastructures.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index() {
        return "ajax";
    }

}