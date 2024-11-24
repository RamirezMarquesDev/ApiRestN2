package com.ramirez.n1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ramirez.n1.entities.Endereco;
import com.ramirez.n1.entities.User;
import com.ramirez.n1.services.UserService;

@Controller
public class CadastrarController {

    @Autowired
    private UserService userService;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cadastrar";
    }

    // @PostMapping("/salvar")
    // public String salvar(@ModelAttribute User user, @ModelAttribute Endereco
    // endereco,
    // RedirectAttributes redirectAttributes) {
    // try {
    // // Validações simples
    // if (user == null || user.getName() == null || user.getEmail() == null
    // || user.getPassword() == null
    // || user.getBirthDate() == null) {
    // throw new IllegalArgumentException("Todos os campos devem ser preenchidos
    // corretamente!");
    // }

    // if (endereco == null || endereco.getLogradouro() == null ||
    // endereco.getNumber() == null
    // || endereco.getBairro() == null || endereco.getCep() == null ||
    // endereco.getCidade() == null
    // || endereco.getEstado() == null) {
    // throw new IllegalArgumentException("Todos os campos do endereço devem ser
    // preenchidos!");
    // }

    // // Chama o serviço para salvar o usuário e o endereço
    // User savedUser = userService.save(user, endereco);

    // // Mensagens de sucesso ou erro
    // if (savedUser != null) {
    // redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com
    // sucesso!");
    // return "redirect:/login";
    // } else {
    // redirectAttributes.addFlashAttribute("messagemErro", "Erro ao cadastrar
    // usuário!");
    // return "cadastrar";
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // redirectAttributes.addFlashAttribute("error", "Erro ao salvar usuário: " +
    // e.getMessage());
    // return "cadastrar";
    // }
    // }
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute User user, @ModelAttribute Endereco endereco, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        try {
            // Verifica se há erros de validação nos objetos
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("messagemErro",
                        "Erro ao salvar: preencha todos os campos corretamente!");
                return "redirect:/cadastrar"; // Redireciona para a página de cadastro
            }

            // Chama o serviço para salvar o usuário e o endereço
            User savedUser = userService.save(user, endereco);

            // Verifica se o usuário foi salvo com sucesso
            if (savedUser != null) {
                redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso!");
                return "redirect:/login"; // Redireciona para a página de login
            } else {
                // Caso o usuário seja null (e-mail já existe ou falha no salvamento)
                redirectAttributes.addFlashAttribute("messagemErro",
                        "Já existe um usuário cadastrado com este e-mail.");
                return "redirect:/cadastrar"; // Redireciona de volta para a página de cadastro com a mensagem de erro
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("messagemErro", "Erro desconhecido: " + e.getMessage());
            return "redirect:/cadastrar"; // Redireciona para a página de cadastro em caso de erro
        }
    }

}
