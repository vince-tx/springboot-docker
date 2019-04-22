package com.tang.springbootdocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author tangxiao
 * @create 2019-03-29 16:10
 * @Since --
 **/
@RestController
public class AppController {

    @GetMapping("/helloworld")
    public String getString() {
        return "Hello world~ docker springboot ";
    }

    @GetMapping("/wode")
    public String geiwo(@NotNull String name) {
        return "我的名字是" + name;
    }

}
