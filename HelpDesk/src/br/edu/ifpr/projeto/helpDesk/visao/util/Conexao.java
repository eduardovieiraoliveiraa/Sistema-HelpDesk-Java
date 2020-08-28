/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.projeto.helpDesk.visao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author eduar
 */
public class Conexao {
    
    public static Connection getConexao() throws SQLException{
        
        try {
            //definição do driver de conexao com o banco mysql
            Class.forName("com.mysql.jdbc.Driver");
            //definição dos parametros de conexao
        return DriverManager.getConnection("jdbc:mysql://localhost/projetohelpdesk","root","root");
        } catch (ClassNotFoundException e) {
            throw new SQLDataException(e.getMessage());    
        }
    }
    
    public static void main(String[] args) {
        
        try {
            getConexao();
            System.out.println("Conexão relizada com sucesso");
        } catch (SQLException ex) {
            System.out.println("Conexão não realizada, verificar log");
            ex.printStackTrace();
        }
    }
}
