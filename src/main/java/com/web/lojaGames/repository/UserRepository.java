package com.web.lojaGames.repository;

import java.util.Optional;

import com.web.lojaGames.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUsuario(String usuario);

}
