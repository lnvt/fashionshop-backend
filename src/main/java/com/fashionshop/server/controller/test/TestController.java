package com.fashionshop.server.controller.test;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {
    @GetMapping("helloworld")
    public String HelloWorld() {return "Hello world";}

    @GetMapping("otherstring")
    public OtherString OtherStrings() {
        return new OtherString("Other string");
    }

    @GetMapping("hello/{id}")
    public OtherString helloVariable(@PathVariable String id)
    {
        //throw new RuntimeException("Something went wrong");
        return new  OtherString(String.format("Hello Variable, %s",id));
    }
}
