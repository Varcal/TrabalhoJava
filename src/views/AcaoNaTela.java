/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author varcal
 */
public enum AcaoNaTela {
    
    
    Inserir(1),
    Editar(2),
    Detalhes(3);
    
    public int valor;
    
    AcaoNaTela(int valor){
        this.valor= valor;
    }
}
