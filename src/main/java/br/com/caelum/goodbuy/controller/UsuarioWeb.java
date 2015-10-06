package br.com.caelum.goodbuy.controller;

import br.com.caelum.goodbuy.modelo.Usuario;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import java.io.Serializable;

/**
 * @author lucas
 */
@Component
@SessionScoped
public class UsuarioWeb implements Serializable {

    private Usuario logado;

    public void login(Usuario usuario) {
        this.logado = usuario;
    }

    public String getNome() {
        return logado.getNome();
    }

    public boolean isLogado() {
        return logado != null;
    }

    public void logout() {
        this.logado = null;
    }
}
