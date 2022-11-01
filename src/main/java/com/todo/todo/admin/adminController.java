package com.todo.todo.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class adminController {

    @GetMapping("/manageUser")
    public void manageUser(){

    }

    @GetMapping("/manageUser22")
    public void manageUser22(){

    }
}
