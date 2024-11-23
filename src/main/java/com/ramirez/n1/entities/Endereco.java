package com.ramirez.n1.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String number;
    private String quadra;
    private String lote;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    @OneToOne(mappedBy = "endereco")
    private User user;

    public Endereco() {
    }

    public Endereco(Long id, String logradouro, String number, String quadra, String lote, String bairro, String cep,
            String cidade, String estado, User user) {
        this.id = id;
        this.logradouro = logradouro;
        this.number = number;
        this.quadra = quadra;
        this.lote = lote;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getlogradouro() {
        return logradouro;
    }

    public void setlogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getquadra() {
        return quadra;
    }

    public void setquadra(String quadra) {
        this.quadra = quadra;
    }

    public String getlote() {
        return lote;
    }

    public void setlote(String lote) {
        this.lote = lote;
    }

    public String getbairro() {
        return bairro;
    }

    public void setbairro(String bairro) {
        this.bairro = bairro;
    }

    public String getcep() {
        return cep;
    }

    public void setcep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", logradouro=" + logradouro + ", number=" + number + ", quadra=" + quadra
                + ", lote=" + lote + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado
                + "]";
    }
}
