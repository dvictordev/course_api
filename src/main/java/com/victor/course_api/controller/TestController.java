package com.victor.course_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestController {

    @GetMapping("/")
    public String test() {
        return "teste 123";
    }
}
