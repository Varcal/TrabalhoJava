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
import models.Modelo;
import models.ModeloTipo;
import models.Montadora;


/**
 *
 * @author varcal
 */
public class ModeloController {
    
    private final Connection _con;
    private final String campos = "m.Id, m.Nome, m.MontadoraId, m.ModeloTipoId, m.Ativo";

    public ModeloController() {
        this._con = DbContext.getInstance().getConnection();
    }
    
     public void salvar(Modelo modelo) throws SQLException{
        
        if(modelo.getId() > 0){
              alterar(modelo);
        }else{
            inserir(modelo);
        }
    }
    
    public void excluir (Modelo modelo) throws SQLException{
        
                
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Modelo ");
        sb.append("SET ");
        sb.append("Ativo = ? ");
        sb.append("WHERE Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, false);
        p.setInt(2, modelo.getId());
        
        p.executeUpdate();
        
    }
    
    public Modelo buscarPorId(int id) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" ,mt.Nome as ModeloTipoNome, mt.Ativo as ModeloTipoAtivo, ");
        sb.append(" md.Nome as MontadoraNome, md.Ativo as MontadoraAtivo ");
        sb.append(" from Modelo m ");
        sb.append(" Inner join ModeloTipo mt on mt.Id = m.ModeloTipoId ");
        sb.append(" Inner join Montadora md on md.Id = m.MontadoraId ");
        sb.append(" Where m.Id = ?");
       
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setInt(1, id);
        ResultSet rs  = p.executeQuery();
        
        Modelo modelo = null;
        
        while(rs.next()){
            modelo = new Modelo(rs.getInt("Id"), rs.getString("Nome"), rs.getInt("MontadoraId"), rs.getInt("ModeloTipoId"), rs.getBoolean("Ativo"));
            modelo.ModeloTipo = new ModeloTipo(rs.getInt("ModeloTipoId"), rs.getString("ModeloTipoNome"), rs.getBoolean("ModeloTipoAtivo"));
            modelo.Montadora = new Montadora(rs.getInt("MontadoraId"), rs.getString("MontadoraNome"), rs.getBoolean("MontadoraAtivo"));
        }
        
        fecharConexao(rs, p);
        return modelo;
    }
    
    public Modelo buscarPorNome(String nome) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" ,mt.Nome as ModeloTipoNome, mt.Ativo as ModeloTipoAtivo, ");
        sb.append(" md.Nome as MontadoraNome, md.Ativo as MontadoraAtivo ");
        sb.append(" from Modelo m ");
        sb.append(" Inner join ModeloTipo mt on mt.Id = m.ModeloTipoId ");
        sb.append(" Inner join Montadora md on md.Id = m.MontadoraId ");
        sb.append(" Where m.Nome = ?");
       
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, nome);
        ResultSet rs  = p.executeQuery();
        
        Modelo modelo = null;
        
        while(rs.next()){
            modelo = new Modelo(rs.getInt("Id"), rs.getString("Nome"), rs.getInt("MontadoraId"), rs.getInt("ModeloTipoId"), rs.getBoolean("Ativo"));
            modelo.ModeloTipo = new ModeloTipo(rs.getInt("ModeloTipoId"), rs.getString("ModeloTipoNome"), rs.getBoolean("ModeloTipoAtivo"));
            modelo.Montadora = new Montadora(rs.getInt("MontadoraId"), rs.getString("MontadoraNome"), rs.getBoolean("MontadoraAtivo"));
        }
        
        fecharConexao(rs, p);
        return modelo;
    }
    
    public ArrayList<Modelo> selecionarTodos() throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" from Modelo");
       
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            Modelo modelo = new Modelo(rs.getInt("Id"), rs.getString("Nome"), rs.getInt("MontadoraId"), rs.getInt("ModeloTipoId"), rs.getBoolean("Ativo"));
            modelos.add(modelo);
        }
        fecharConexao(rs, p);
        return modelos;
    }   
    
    public ArrayList<Modelo> selecionarTodosAtivosInativos(String situacao, String pesquisa) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(campos);
        sb.append(" ,mt.Nome as ModeloTipoNome, mt.Ativo as ModeloTipoAtivo ");
        sb.append(" ,md.Nome as MontadoraNome, md.Ativo as MontadoraAtivo ");
        sb.append(" from Modelo m ");
        sb.append(" Inner join ModeloTipo mt on mt.Id = m.ModeloTipoId ");
        sb.append(" Inner join Montadora md on md.Id = m.MontadoraId ");
        sb.append(" WHERE m.Ativo = ? ");
        sb.append(!"".equals(pesquisa) ? "And UPPER(Nome) Like '%"+pesquisa.toUpperCase()+"%'" : "");       
       
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, "Ativos".equals(situacao));
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            Modelo modelo = new Modelo(rs.getInt("Id"), rs.getString("Nome"), rs.getInt("MontadoraId"), rs.getInt("ModeloTipoId"), rs.getBoolean("Ativo"));
            modelo.ModeloTipo = new ModeloTipo(rs.getInt("ModeloTipoId"), rs.getString("ModeloTipoNome"), rs.getBoolean("ModeloTipoAtivo"));
            modelo.Montadora = new Montadora(rs.getInt("MontadoraId"), rs.getString("MontadoraNome"), rs.getBoolean("MontadoraAtivo"));      
            modelos.add(modelo);
        }
        fecharConexao(rs, p);
        return modelos;
    }
    
    public int retornaId(String nome) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("Select ");
        sb.append(" Id ");
        sb.append(" from Modelo ");
        sb.append(" Where Nome = ? ");
       
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, nome);
        ResultSet rs  = p.executeQuery();
        
        int retorno = 0;
        
        while(rs.next()){
            retorno = rs.getInt("Id");
            
        }
        fecharConexao(rs, p);
        return retorno;
    }
    
    private void inserir (Modelo modelo) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Insert into Modelo ");
        sb.append("(Nome, MontadoraId, ModeloTipoId, Ativo) ");
        sb.append("values");
        sb.append("(?,?,?,?) ");
          
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setString(1, modelo.getNome());
        p.setInt(2, modelo.getMontadotaId());
        p.setInt(3, modelo.getModeloTipoId());
        p.setBoolean(4, modelo.isAtivo());
        
        p.executeUpdate();    
        
    }

    private void alterar (Modelo modelo) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE Modelo ");
        sb.append("SET ");
        sb.append("Nome = ?, ");
        sb.append("MontadoraId = ?, ");
        sb.append("ModeloTipoId = ?, ");
        sb.append("Ativo = ? ");
        sb.append("WHERE Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        
        p.setString(1, modelo.getNome());
        p.setInt(2, modelo.getMontadotaId());
        p.setInt(3, modelo.getModeloTipoId());
        p.setBoolean(4, modelo.isAtivo());
        p.setInt(5, modelo.getId());
        
        p.executeUpdate();
       
    }
    
    private void fecharConexao(ResultSet rs, PreparedStatement p) throws SQLException{    
      p.close();
      rs.close();
    }
    
}
