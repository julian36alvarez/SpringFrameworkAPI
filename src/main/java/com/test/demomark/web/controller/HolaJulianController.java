package com.test.demomark.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaJulianController {
    @GetMapping("/hola")
    public String saludar(){
        return "Olix es un perrito canson \uD83E\uDDD1\u200D\uD83D\uDE80 ";
    }
}
