package com.example.mochileiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mochileiro.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
    public Usuario findByNomeOrEmail(String nome, String email);
}
