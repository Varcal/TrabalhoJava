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
public class Veiculo {
    private int id;
    private int modeloId;
    private int ano;
    private String cor;
    private float valor;
    private boolean ativo;
    
    public Veiculo(int modeloId, int ano, String cor, float valor, boolean ativo) {
        this.modeloId = modeloId;
        this.ano = ano;
        this.cor = cor;
        this.valor = valor;
        this.ativo = ativo;
    }
    
    public Veiculo(int id, int modeloId, int ano, String cor, float valor, boolean ativo) {
        this.id = id;
        this.modeloId = modeloId;
        this.ano = ano;
        this.cor = cor;
        this.valor = valor;
        this.ativo = ativo;
    }
    
    
}
