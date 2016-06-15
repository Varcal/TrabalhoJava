/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author varcal
 */
public class DbContext {
    
    private static final String driverName = "oracle.jdbc.driver.OracleDriver";
    private static final String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
    private static final String username = "adminCarros";
    private static final String password = "123456";
    private Connection connection;
    private static DbContext instance_connection = null;
    private ResultSet rs = null;
    private Statement st = null;
  
    
    public Connection getConnection(){
        try{
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Conexão efetuada");
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Não foi encontrado o driver do Oracle \n"+ex.getMessage(),"Atenção",JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ocorreu problema de conexão com o banco de dados. \nMotivo:"+ex.getMessage(),"Atenção",JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    
    public static DbContext getInstance(){
       if(instance_connection == null){
    	   instance_connection = new DbContext();
       }
       return instance_connection;
   }
}
