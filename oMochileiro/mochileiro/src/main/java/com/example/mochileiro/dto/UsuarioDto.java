package com.example.mochileiro.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private String nome;
    private String email;
    private String senha;

    public UsuarioDto(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
