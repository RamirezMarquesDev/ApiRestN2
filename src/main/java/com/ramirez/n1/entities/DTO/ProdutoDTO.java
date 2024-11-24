package com.ramirez.n1.entities.DTO;

public class ProdutoDTO {

    private String nome;
    private String marca;
    private String modelo;
    private String cor;

    // Construtor
    public ProdutoDTO(String nome, String marca, String modelo, String cor) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
