package com.ativo247.ativo247api.repository;

import com.ativo247.ativo247api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Optional<Usuario> findByLogin(String login);
}
