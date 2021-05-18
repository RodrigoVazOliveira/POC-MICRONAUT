package com.example.usuario;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller(value = "/")
public class UsuarioRestController {

    @Inject
    private UsuarioService usuarioService;

    @Post
    public HttpResponse<Usuario> cadastrarNovoUsuario(@Body Usuario usuario) {
        Usuario usuarioResposta = usuarioService.cadastrarNovoUsuario(usuario)
        return HttpResponse.status(HttpStatus.CREATED).body(usuarioResposta);
    }

    @Put
    public HttpResponse<Usuario> atualizarTodoUsuario(@Body Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarTodoUsuario(usuario);
        return HttpResponse.status(HttpStatus.CREATED).body(usuarioAtualizado);
    }

    @Get
    public HttpResponse<Iterable<Usuario>> mostrarTodosUsuarios() {
        Iterable<Usuario> usuarios = usuarioService.obterTodosUsuarios();
        return HttpResponse.status(HttpStatus.OK).body(usuarios);
    }
}
