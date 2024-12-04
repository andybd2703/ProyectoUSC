package com.example.BackendDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackendDemo.model.Usuario;
import com.example.BackendDemo.repository.IUsuarioRespository;


@Service
public class Usuarioservice {

    @Autowired
    private IUsuarioRespository usuarioRespository;



    //OPERACIONES DEL CRUD


    //LISTAR TODOS LOS USUARIOS
    public List<Usuario> selectAllUsers(){
        return usuarioRespository.findAll();
    }

    // Encontrar un solo usuario
    public Optional<Usuario> selectBId(Long id){
        return usuarioRespository.findById(id);
    }

    //CREAR

    public Usuario createUser(Usuario nuevoUsuario){
        return usuarioRespository.save(nuevoUsuario);
    }

    //EDITAR
    
    //ELIMINAR
}
