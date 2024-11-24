package com.ramirez.n1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ramirez.n1.entities.DTO.ProdutoDTO;
import com.ramirez.n1.services.ProdutoService;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public String produtos() {
        return "produtos";
    }

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.salvarProduto(produtoDTO);
    }

    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO buscarProduto(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

}
