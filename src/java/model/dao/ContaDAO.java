/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabaseMySQL;
import model.domain.Conta;

/**
 *
 * @author mateus
 */
public class ContaDAO {
    public static ArrayList<Conta> listar(){
        ArrayList<Conta> allConta = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from conta");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Conta conta = new Conta();
                conta.setCodigo(resultado.getString("codigo"));
                conta.setNome(resultado.getString("nome"));
                allConta.add(conta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allConta;
    }
    
    public static Conta select(Conta conta){
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from conta where codigo = ?");
            pst.setString(1, conta.getCodigo());
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                conta.setNome(resultado.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return conta;
    }
}
