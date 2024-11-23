package com.ramirez.n1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // O nome do arquivo HTML sem a extensão
    }

    @PostMapping("/confirmarLogin")
    public String logar() {
        // Lógica para salvar os dados

        // Após salvar, redireciona para a página de login
        return "redirect:/produtos";
    }

}
