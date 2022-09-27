package com.example.mochileiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "O nome deve ter no minimo 3 caracteres!")
    @NotBlank(message = "O nome e obrigatorio!")
    @Column(name = "nome", length = 200, nullable = true)
    private String nome;

    @Email(message = "Insira um Email valido!")
    @NotBlank(message = "O email e obrigatorio!")
    @Column(name = "email", length = 200, nullable = true)
    private String email;

    @NotBlank(message = "O senha e obrigatorio!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = true)
    private String senha;

    @NotBlank(message = "O telefone e obrigatorio!")
    @Column(name = "telefone", length = 50, nullable = true)
    private String telefone;
}