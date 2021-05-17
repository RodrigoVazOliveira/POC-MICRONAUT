package com.example.usuario;

import io.micronaut.context.annotation.Bean;
import io.micronaut.runtime.context.scope.ThreadLocal;

import javax.inject.Singleton;

@Singleton
public class UsuarioService {

    private Usuario usuario;

    public Usuario gerarUsuario() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNomeCompleto("Rodrigo Vaz");
        usuario.setEmail("rodrigo.vaz@zup.com.br");
        return usuario;
    }
}
