package com.example.mochileiro.DAO;
import org.springframework.data.repository.CrudRepository;

import com.example.mochileiro.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{
    
}
