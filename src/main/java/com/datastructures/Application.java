package com.datastructures;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
