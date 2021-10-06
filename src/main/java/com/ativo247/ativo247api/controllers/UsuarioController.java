package com.ativo247.ativo247api.controllers;


import com.ativo247.ativo247api.models.Usuario;
import com.ativo247.ativo247api.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    UsuarioRepository repository;
    PasswordEncoder encoder;
    public Boolean logado = false;
    public UsuarioController(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    @CrossOrigin
    @PostMapping(path ="/novo-usuario")
    public String cadastrarUsuario(@RequestBody Usuario usuario){
        if (repository.findByLogin(usuario.getLogin()).isPresent()){
            return "Usario já cadastrado!";
        }
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        repository.save(usuario);
        return "Usuario cadastrado!";
    }
    @PostMapping(path="/logar")
    public String logarUsuario(@RequestBody Usuario usuario){
        if(repository.findByLogin(usuario.getLogin()).isEmpty()){
            return "Usuario inexistente!";
        }
        Usuario user = repository.findByLogin(usuario.getLogin()).orElse(new Usuario());
        if(encoder.matches(usuario.getPassword(),user.getPassword())){
            logado = true;
            return "Usuario Logado!";
        }
        else {
            return "Senha incorreta";
        }
    }
}
