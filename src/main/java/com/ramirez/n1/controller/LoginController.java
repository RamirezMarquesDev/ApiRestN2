package com.ramirez.n1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ramirez.n1.entities.User;
import com.ramirez.n1.services.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login"; // O nome do arquivo HTML sem a extensão
    }

    @PostMapping("/confirmarLogin")
    public String confirmarLogin(String email, String password, RedirectAttributes redirect, Model model) {

        User usuarioLogado = userService.validUser(email, password);

        if (usuarioLogado != null) {
            // menssagem de sucesso
            redirect.addFlashAttribute("mensagem", "Logado com sucesso!");
            // armazena o usuario logado nesta sessão
            model.addAttribute("usuarioLogado", usuarioLogado);

            return "redirect:/produtos";
        } else {
            // menssagem de erro
            redirect.addFlashAttribute("mensagemErro", "Erro ao logar Credenciais inválidas!");
            return "redirect:/login";
        }
    }

}
