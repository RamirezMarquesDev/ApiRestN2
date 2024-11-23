package com.ramirez.n1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastrarController {

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar() {
        // Lógica para salvar os dados

        // Após salvar, redireciona para a página de login
        return "redirect:/login";
    }

}
