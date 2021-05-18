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
        Usuario usuarioSalvo = procurarUsuarioPeloId(usuario.getId());
        usuarioSalvo.setNomeCompleto(usuario.getNomeCompleto());
        usuarioSalvo.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioSalvo);
    }

    public Usuario procurarUsuarioPeloId(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isEmpty()) {
            throw new RuntimeException("Usuário com id " + id + " não localizado!");
        }

        return optionalUsuario.get();
    }

    public Iterable<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuarioParcialmente(Usuario usuario) {
        Usuario usuarioSalvo = procurarUsuarioPeloId(usuario.getId());

        if (usuario.getNomeCompleto() != null) {
            usuarioSalvo.setNomeCompleto(usuario.getNomeCompleto());
        }

        if (usuario.getEmail() != null) {
            usuarioSalvo.setEmail(usuario.getEmail());
        }

        return usuarioRepository.save(usuarioSalvo);
    }
}
