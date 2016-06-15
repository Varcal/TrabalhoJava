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
public class Modelo {
    private int id;
    private String nome;
    private int montadoraId;
    private int modeloTipoId;
    private boolean ativo;
    
    public ModeloTipo ModeloTipo;
    public Montadora Montadora;

    public Modelo(String nome, int montadoraId, int modeloTipoId) {
        this.nome = nome;
        this.montadoraId = montadoraId;
        this.modeloTipoId = modeloTipoId;
        this.ativo = true;
    }
    
    public Modelo(int id, String nome, int montadoraId, int modeloTipoId, boolean ativo)
    {
        this.id = id;
        this.nome = nome;
        this.montadoraId = montadoraId;
        this.modeloTipoId = modeloTipoId;
        this.ativo = ativo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getId(){
        return id;
    }
    
    public int getMontadotaId(){
        return montadoraId;
    }

    public int getModeloTipoId() {
        return modeloTipoId;
    }
            
    public boolean isAtivo(){
        return ativo;
    }
}
