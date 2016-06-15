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
public class ModeloTipo {
    private int id;
    private String nome;
    private boolean ativo;

    
    public ModeloTipo(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
     
    public ModeloTipo(int id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }   
}
