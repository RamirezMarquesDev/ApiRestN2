package com.ramirez.n1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramirez.n1.entities.Produto;
import com.ramirez.n1.entities.DTO.ProdutoDTO;
import com.ramirez.n1.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setMarca(produtoDTO.getMarca());
        produto.setModelo(produtoDTO.getModelo());
        produto.setCor(produtoDTO.getCor());

        Produto produtoSalvo = produtoRepository.save(produto);

        return new ProdutoDTO(produtoSalvo.getNome(), produtoSalvo.getMarca(), produtoSalvo.getModelo(),
                produtoSalvo.getCor());
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> new ProdutoDTO(produto.getNome(), produto.getMarca(), produto.getModelo(),
                        produto.getCor()))
                .collect(Collectors.toList());
    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com ID: " + id));
        return new ProdutoDTO(produto.getNome(), produto.getMarca(), produto.getModelo(), produto.getCor());
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
