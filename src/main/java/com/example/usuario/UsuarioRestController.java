package com.example.usuario;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller(value = "/")
public class UsuarioRestController {

    @Inject
    private UsuarioService usuarioService;

    @Get
    public HttpResponse<Usuario> home() {
        return HttpResponse.status(HttpStatus.CREATED).body(usuarioService.gerarUsuario());
    }
}
