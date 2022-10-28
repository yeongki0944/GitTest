package com.todo.todo.logout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping("logout")
    public void logout(){

    }


    @GetMapping("newlogout")
    public void newlogout(){

    }
}
