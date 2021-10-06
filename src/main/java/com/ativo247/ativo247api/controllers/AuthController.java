package com.ativo247.ativo247api.controllers;

public class AuthController {
    public Boolean logado;

    public AuthController(Boolean logado) {
        this.logado = true;
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }
}
