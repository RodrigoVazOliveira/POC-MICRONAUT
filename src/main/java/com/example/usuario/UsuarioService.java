package com.example.usuario;

import io.micronaut.context.annotation.Bean;
import io.micronaut.runtime.context.scope.ThreadLocal;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarNovoUsuario(Usuario novoUsuario) {
        return usuarioRepository.save(novoUsuario);
    }

    public Usuario atualizarTodoUsuario(Usuario usuario) {

    }

    public Usuario procurarUsuarioPeloId(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isEmpty()) {
            throw new RuntimeException("Usuário com id " + id + " não localizado!");
        }

        return optionalUsuario.get();
    }
}
