package com.example.mochileiro.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mochileiro.DAO.IUsuario;
import com.example.mochileiro.model.Usuario;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuario dao;
    
    @GetMapping()
    public List<Usuario> listaUsuarios () {
        return (List<Usuario>) dao.findAll();
    }
}
