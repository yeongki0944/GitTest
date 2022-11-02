package com.todo.todo.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/login")
public class login {

        @GetMapping("login")
        public void lgoin(){

        }


        @GetMapping("newlogin")
        public void newlog(){

        }
    }

