package com.ramirez.n1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ramirez.n1.services.UserService;

@Controller
public class ProdutoController {

    @Autowired
    UserService userService;

    @GetMapping("/produtos")
    public String produtos() {
        return "produtos";
    }

}
