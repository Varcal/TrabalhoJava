/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Montadora;

/**
 *
 * @author varcal
 */
public class MontadoraController {
    
    private final Connection _con;
    private final String campos = "Id, Nome, Ativo";

    public MontadoraController() {
        this._con = DbContext.getInstance().getConnection();
    }
     
    public void salvar(Montadora montadora) throws SQLException{
        
        if(montadora.getId() > 0){
              alterar(montadora);
        }else{
            inserir(montadora);
        }
    }
    
    public void excluir (Montadora montadora) throws SQLException{
        
        montadora.Desativar();
        
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Montadora ");
        sb.append("SET ");
        sb.append("Ativo = ? ");
        sb.append("WHERE Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, montadora.isAtivo());
        p.setInt(2, montadora.getId());
        
        p.executeUpdate();
        
    }
    
    public ArrayList<Montadora> selecionarTodos() throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" from Montadora");
       
        ArrayList<Montadora> montadoras = new ArrayList<Montadora>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            Montadora montadora = new Montadora(rs.getInt("Id"), rs.getString("Nome"), rs.getBoolean("Ativo"));
            montadoras.add(montadora);
        }
        fecharConexao(rs, p);
        return montadoras;
    }   
    
    public ArrayList<Montadora> selecionarTodosAtivosInativos(String situacao, String pesquisa) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" from Montadora ");
        sb.append("WHERE Ativo = ? ");
        sb.append(!"".equals(pesquisa) ? "And UPPER(Nome) Like '%"+pesquisa.toUpperCase()+"%'" : "");       
       
        ArrayList<Montadora> montadoras = new ArrayList<Montadora>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, "Ativos".equals(situacao));
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            Montadora montadora = new Montadora(rs.getInt("Id"), rs.getString("Nome"), rs.getBoolean("Ativo"));
            montadoras.add(montadora);
        }
        fecharConexao(rs, p);
        return montadoras;
    }
    
    public int retornaMontadoraId(String nome) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append("Id");
        sb.append(" from Montadora ");
        sb.append("Where UPPER(Nome) = ?");       
       
        
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, nome.toUpperCase());
        ResultSet rs  = p.executeQuery();
        int montadoraId = 0;
        while(rs.next()){
            montadoraId = rs.getInt("Id");
        }
        
        
        fecharConexao(rs, p);
        return montadoraId;
    }
    
    private void inserir (Montadora montadora) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Insert into Montadora ");
        sb.append("(Nome, Ativo) ");
        sb.append("values");
        sb.append("(?,?) ");
          
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, montadora.getNome());
        p.setBoolean(2, montadora.isAtivo());
        
        p.executeUpdate();    
        
    }

    private void alterar (Montadora montadora) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Montadora ");
        sb.append("SET ");
        sb.append("Nome = ?, ");
        sb.append("Ativo = ? ");
        sb.append("WHERE Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        
        p.setString(1, montadora.getNome());
        p.setBoolean(2, montadora.isAtivo());
        p.setInt(3, montadora.getId());
        
        p.executeUpdate();
       
    }
    
    private void fecharConexao(ResultSet rs, PreparedStatement p) throws SQLException{    
      p.close();
      rs.close();
    }
}
