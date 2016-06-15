/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author varcal
 */
public class Usuario {
    private int id;
    private String login;
    private String senha;
    private boolean ativo;

    
    public Usuario(String login, String senha, boolean ativo) {
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }
    
    public Usuario(int id, String login, String senha, boolean ativo) {
        this.id = id;
        this.login = login;
        this.senha = StringHelper.encriptar(senha);
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }
   
    
}
