package com.todo.todo.cart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class CartController {

    @GetMapping("cart")
    public void cart(){

    }


    @GetMapping("newCart")
    public void newCart(){

    }

    @GetMapping("newCart2")
    public void newCart2(){

    }
}
