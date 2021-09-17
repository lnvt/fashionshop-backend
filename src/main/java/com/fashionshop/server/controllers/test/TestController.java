package com.fashionshop.server.controllers.test;

import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {
    @GetMapping("/helloworld")
    public String HelloWorld() {return "Hello world";}

    @GetMapping("/otherstring")
    public OtherString OtherStrings() {
        return new OtherString("Other string");
    }

    @GetMapping("/hello/{message}")
    public OtherString helloVariable(@PathVariable String message)
    {
        return new  OtherString(message);
    }
}
