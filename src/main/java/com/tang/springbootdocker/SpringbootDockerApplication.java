package com.tang.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringbootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerApplication.class, args);
    }


    @RestController
    class tee {

        @GetMapping("getString")
        public String getString() {
            return "docker springboot hello world~";
        }

    }
}
