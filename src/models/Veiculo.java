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
    private String ano;
    private String cor;
    private String placa;
    private float valor;
    private String descricao;
    private boolean vendido;
    private boolean ativo;
    public Modelo Modelo;
    
    public Veiculo(int modeloId, String ano, String cor, String placa, float valor, String descricao) {
        this.modeloId = modeloId;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.valor = valor;
        this.descricao = descricao;
        ativar();
    }
    
    public Veiculo(int id, int modeloId, String ano, String cor, String placa, float valor, String descricao, boolean vendido, boolean ativo) {
        this.id = id;
        this.modeloId = modeloId;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.valor = valor;
        this.descricao = descricao;
        this.vendido = vendido;
        this.ativo = ativo;
    }
    
    public Veiculo(int id, int modeloId, String ano, String cor, String placa, float valor, String descricao) {
        this.id = id;
        this.modeloId = modeloId;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
        this.valor = valor;
        this.descricao = descricao;
        this.vendido = true;
        this.ativo = true;
    }

    public int getId() {
        return id;
    }

    public int getModeloId() {
        return modeloId;
    }
    
    public String getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }
    
    public String getPlaca() {
        return placa;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
      
    public boolean isVendido() {
        return vendido;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public Modelo getModelo(){
        return Modelo;
    }
    
    public void vender(){
        this.vendido = true;
    }
    
    public void ativar(){
        this.ativo = true;
    }
    
    public void desativar(){
        this.ativo = false;
    }
}
