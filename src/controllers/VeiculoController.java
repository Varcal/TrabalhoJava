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
import models.Veiculo;

/**
 *
 * @author varcal
 */
public class VeiculoController {
    
    private final Connection _con;
    private final String campos = "v.Id, v.ModeloId, v.Ano, v.Cor, v.Placa, CAST(v.Valor as NUMBER(18,2)) as Valor, v.Descricao, v.Vendido, v.Ativo";

    public VeiculoController() {
        this._con = DbContext.getInstance().getConnection();
    }
    
    public void Salvar(Veiculo veiculo)throws SQLException{
        if(veiculo.getId()>0){
            alterar(veiculo);
        }else{
            inserir(veiculo);
        }
    }
    
    private void inserir(Veiculo veiculo) throws SQLException{
        StringBuilder sb = new StringBuilder();
        
        sb.append("Insert into Veiculo ");
        sb.append("(ModeloId, Ano, Cor, Placa, Valor, Descricao, Vendido, Ativo) ");
        sb.append("Values");
        sb.append("(?,?,?,?,?,?,?,?)");
        
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setInt(1, veiculo.getModeloId());
        p.setString(2, veiculo.getAno());
        p.setString(3, veiculo.getCor());
        p.setString(4, veiculo.getPlaca().toUpperCase());
        p.setFloat(5, veiculo.getValor());
        p.setString(6, veiculo.getDescricao());
        p.setBoolean(7, veiculo.isVendido());
        p.setBoolean(8, veiculo.isAtivo());
        
        p.executeUpdate();
    }
    
    private void alterar(Veiculo veiculo) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("Update Veiculo set ");
        sb.append("ModeloId = ?, ");
        sb.append("Ano = ?, ");
        sb.append("Cor = ?, ");
        sb.append("Placa = ?,");
        sb.append("Valor = ?, ");
        sb.append("Descricao = ?, ");
        sb.append("Vendido = ?, ");
        sb.append("Ativo = ? ");
        sb.append("where Id = ? ");
        
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setInt(1, veiculo.getModeloId());
        p.setString(2, veiculo.getAno());
        p.setString(3, veiculo.getCor());
        p.setString(4, veiculo.getPlaca().toUpperCase());
        p.setFloat(5, veiculo.getValor());
        p.setString(6, veiculo.getDescricao());
        p.setBoolean(7, veiculo.isVendido());
        p.setBoolean(8, veiculo.isAtivo());
        p.setInt(9, veiculo.getId());
        
        p.executeUpdate();
    }
    
    public void excluir(Veiculo veiculo) throws SQLException{
        
        StringBuilder sb = new StringBuilder();
        sb.append("Update Veiculo set ");
        sb.append("Ativo = ? ");
        sb.append("where Id = ? ");
        
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, veiculo.isAtivo());
        p.setInt(2, veiculo.getId());
        
        p.executeUpdate();
    }
    
    public ArrayList<Veiculo> selecionarTodos() throws SQLException{
        
        ArrayList<Veiculo> veiculoList = new ArrayList<Veiculo>();
       
        StringBuilder sb = new StringBuilder();
        
        sb.append("Select ");
        sb.append(campos);
        sb.append(" ,m.Nome as ModeloNome, m.Ativo as ModeloAtivo,");
        sb.append(" mt.Id as ModeloTipoId ,mt.Nome as ModeloTipoNome, mt.Ativo as ModeloTipoAtivo, ");
        sb.append(" md.Id as MontadoraId, md.Nome as MontadoraNome, md.Ativo as MontadoraAtivo ");
        sb.append(" from Veiculo v ");
        sb.append(" Inner Join Modelo m on m.Id = v.ModeloId ");
        sb.append(" Inner join ModeloTipo mt on mt.Id = m.ModeloTipoId ");
        sb.append(" Inner join Montadora md on md.Id = m.MontadoraId ");
        sb.append("Where v.Ativo = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setBoolean(1, true);
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            Veiculo veiculo = new Veiculo(rs.getInt("Id"), rs.getInt("ModeloId"), rs.getString("Ano"), rs.getString("Cor"),
                rs.getString("Placa"),rs.getFloat("Valor"), rs.getString("Descricao"), rs.getBoolean("Vendido"),rs.getBoolean("Ativo"));
            
            veiculo.Modelo = new Modelo(rs.getInt("ModeloId"),rs.getString("ModeloNome"),rs.getInt("MontadoraId"),rs.getInt("ModeloTipoId"),rs.getBoolean("ModeloAtivo"));
            veiculo.Modelo.ModeloTipo = new ModeloTipo(rs.getInt("ModeloTipoId"), rs.getString("ModeloTipoNome"), rs.getBoolean("ModeloTipoAtivo"));
            veiculo.Modelo.Montadora = new Montadora(rs.getInt("MontadoraId"), rs.getString("MontadoraNome"), rs.getBoolean("MontadoraAtivo"));
            veiculoList.add(veiculo);
        }
        fecharConexao(rs, p);
        
        return veiculoList;
    }
    
    public ArrayList<Veiculo> selecionarTodos(int montadoraId) throws SQLException{
        
        ArrayList<Veiculo> veiculoList = new ArrayList<Veiculo>();
       
        StringBuilder sb = new StringBuilder();
        
        sb.append("Select ");
        sb.append(campos);
        sb.append(" ,m.Nome as ModeloNome, m.Ativo as ModeloAtivo,");
        sb.append(" mt.Id as ModeloTipoId ,mt.Nome as ModeloTipoNome, mt.Ativo as ModeloTipoAtivo, ");
        sb.append(" md.Id as MontadoraId, md.Nome as MontadoraNome, md.Ativo as MontadoraAtivo ");
        sb.append(" from Veiculo v");
        sb.append(" Inner Join Modelo m on m.Id = v.ModeloId ");
        sb.append(" Inner join ModeloTipo mt on mt.Id = m.ModeloTipoId ");
        sb.append(" Inner join Montadora md on md.Id = m.MontadoraId ");
        sb.append(" Where md.Id = ? ");
        
        
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setInt(1, montadoraId);
        ResultSet rs  = p.executeQuery();
        
        while(rs.next()){
            Veiculo veiculo = new Veiculo(rs.getInt("Id"), rs.getInt("ModeloId"), rs.getString("Ano"), rs.getString("Cor"),
                rs.getString("Placa"),rs.getFloat("Valor"), rs.getString("Descricao"), rs.getBoolean("Vendido"),rs.getBoolean("Ativo"));
            
            veiculo.Modelo = new Modelo(rs.getInt("ModeloId"),rs.getString("ModeloNome"),rs.getInt("MontadoraId"),rs.getInt("ModeloTipoId"),rs.getBoolean("ModeloAtivo"));
            veiculo.Modelo.ModeloTipo = new ModeloTipo(rs.getInt("ModeloTipoId"), rs.getString("ModeloTipoNome"), rs.getBoolean("ModeloTipoAtivo"));
            veiculo.Modelo.Montadora = new Montadora(rs.getInt("MontadoraId"), rs.getString("MontadoraNome"), rs.getBoolean("MontadoraAtivo"));
            veiculoList.add(veiculo);
        }
        fecharConexao(rs, p);
        
        return veiculoList;
    }
    
    public Veiculo buscarPorId(int id) throws SQLException{
        
        Veiculo veiculo = null;
       
        StringBuilder sb = new StringBuilder();
        
        sb.append("Select ");
        sb.append(campos);
        sb.append(" ,m.Nome as ModeloNome, m.Ativo as ModeloAtivo,");
        sb.append(" mt.Id as ModeloTipoId ,mt.Nome as ModeloTipoNome, mt.Ativo as ModeloTipoAtivo, ");
        sb.append(" md.Id as MontadoraId, md.Nome as MontadoraNome, md.Ativo as MontadoraAtivo ");
        sb.append(" from Veiculo v");
        sb.append(" Inner Join Modelo m on m.Id = v.ModeloId ");
        sb.append(" Inner join ModeloTipo mt on mt.Id = m.ModeloTipoId ");
        sb.append(" Inner join Montadora md on md.Id = m.MontadoraId ");
        sb.append(" Where v.Id = ?");
               
        PreparedStatement p = _con.prepareStatement(sb.toString());
        p.setInt(1, id);
        ResultSet rs  = p.executeQuery();
               
        while(rs.next()){
            veiculo = new Veiculo(rs.getInt("Id"), rs.getInt("ModeloId"), rs.getString("Ano"), rs.getString("Cor"),
                rs.getString("Placa"),rs.getFloat("Valor"), rs.getString("Descricao"), rs.getBoolean("Vendido"),rs.getBoolean("Ativo"));
            
            veiculo.Modelo = new Modelo(rs.getInt("ModeloId"),rs.getString("ModeloNome"),rs.getInt("MontadoraId"),rs.getInt("ModeloTipoId"),rs.getBoolean("ModeloAtivo"));
            veiculo.Modelo.ModeloTipo = new ModeloTipo(rs.getInt("ModeloTipoId"), rs.getString("ModeloTipoNome"), rs.getBoolean("ModeloTipoAtivo"));
            veiculo.Modelo.Montadora = new Montadora(rs.getInt("MontadoraId"), rs.getString("MontadoraNome"), rs.getBoolean("MontadoraAtivo"));
        }
        fecharConexao(rs, p);
        
        return veiculo;
    }
    
    private void fecharConexao(ResultSet rs, PreparedStatement p) throws SQLException{    
      p.close();
      rs.close();
    }
    
}
