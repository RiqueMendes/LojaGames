package com.web.lojaGames.service;

import java.nio.charset.Charset;
import java.util.Optional;

import com.web.lojaGames.Model.UserLogin;
import com.web.lojaGames.Model.Usuario;
import com.web.lojaGames.repository.UsuarioRepository;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrUsuario(Usuario usuario){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return repository.save(usuario);
    }

    public Optional<UserLogin> Logar(Optional<UserLogin> user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = repository.findByUsuario(user.get().getUser());

        if(usuario.isPresent()){
            if(encoder.matches(user.get().getPassword(), usuario.get().getSenha())){

                String auth = user.get().getUser() + ":" + user.get().getPassword();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);

                user.get().setToken(authHeader);
                user.get().setName(usuario.get().getNome());

                return user;
            }
        }
        return null;
    }

    
}
