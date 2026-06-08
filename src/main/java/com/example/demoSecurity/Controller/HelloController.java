package com.example.demoSecurity.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String greet(){
        return "Hi guys";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "welcome to springboot"+request.getSession().getId();
    }
}
