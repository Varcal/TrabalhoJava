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
import models.ModeloTipo;

/**
 *
 * @author varcal
 */
public class ModeloTipoController {
    
    private final Connection _con;
    private final String campos = "Id, Nome, Ativo";

    public ModeloTipoController() {
        this._con = DbContext.getInstance().getConnection();
    }
    
    public void salvar(ModeloTipo modeloTipo) throws SQLException{
        
        if(modeloTipo.getId() > 0){
              alterar(modeloTipo);
        }else{
            inserir(modeloTipo);
        }
    }
    
    public void excluir (ModeloTipo modeloTipo) throws SQLException{
        
               
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ModeloTipo ");
        sb.append("SET ");
        sb.append("Ativo = ? ");
        sb.append("WHERE Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, modeloTipo.isAtivo());
        p.setInt(2, modeloTipo.getId());
        
        p.executeUpdate();
        
    }
    
    public ArrayList<ModeloTipo> selecionarTodos() throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" from ModeloTipo");
       
        ArrayList<ModeloTipo> modeloTipoList = new ArrayList<ModeloTipo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            ModeloTipo modeloTipo = new ModeloTipo(rs.getInt("Id"), rs.getString("Nome"), rs.getBoolean("Ativo"));
            modeloTipoList.add(modeloTipo);
        }
        fecharConexao(rs, p);
        return modeloTipoList;
    }   
    
    public ArrayList<ModeloTipo> selecionarTodosAtivosInativos(String situacao) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" from ModeloTipo ");
        sb.append("WHERE Ativo = ? ");       
       
        ArrayList<ModeloTipo> modeloTipoList = new ArrayList<ModeloTipo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, "Ativos".equals(situacao));
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            ModeloTipo modeloTipo = new ModeloTipo(rs.getInt("Id"), rs.getString("Nome"), rs.getBoolean("Ativo"));
            modeloTipoList.add(modeloTipo);
        }
        fecharConexao(rs, p);
        return modeloTipoList;
    }
    
    public int retornaModeloTipoId(String nome) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append("Id");
        sb.append(" from ModeloTipo ");
        sb.append("Where UPPER(Nome) = ?");       
       
        
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, nome.toUpperCase());
        ResultSet rs  = p.executeQuery();
        
        int modelotipoId = 0;
        
        while(rs.next()){
            modelotipoId = rs.getInt("Id");
        }
        
        
        fecharConexao(rs, p);
        return modelotipoId;
    }
     
    private void inserir (ModeloTipo modeloTipo) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Insert into ModeloTipo ");
        sb.append("(Nome, Ativo) ");
        sb.append("values");
        sb.append("(?,?) ");
          
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, modeloTipo.getNome());
        p.setBoolean(2, modeloTipo.isAtivo());
        
        p.executeUpdate();    
        
    }

    private void alterar (ModeloTipo modeloTipo) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ModeloTipo ");
        sb.append("SET ");
        sb.append("Nome = ?, ");
        sb.append("Ativo = ? ");
        sb.append("WHERE Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        
        p.setString(1, modeloTipo.getNome());
        p.setBoolean(2, modeloTipo.isAtivo());
        p.setInt(3, modeloTipo.getId());
        
        p.executeUpdate();
       
    }
    
    private void fecharConexao(ResultSet rs, PreparedStatement p) throws SQLException{    
      p.close();
      rs.close();
    }
}
