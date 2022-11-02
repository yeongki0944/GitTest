package com.todo.todo.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logingoogle")
public class logingoogle {

    @GetMapping("/google")
    public void logingoogle(){
        System.out.println("구글 로그인");
    }
}
