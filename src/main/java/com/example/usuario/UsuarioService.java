package com.example.usuario;

import io.micronaut.context.annotation.Bean;
import io.micronaut.runtime.context.scope.ThreadLocal;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarNovoUsuario(Usuario novoUsuario) {
        return usuarioRepository.save(novoUsuario);
    }
}
