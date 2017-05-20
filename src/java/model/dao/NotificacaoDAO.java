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
import model.domain.Notificacao;

/**
 *
 * @author mateus
 */
public class NotificacaoDAO {
    
    public static boolean insert(Notificacao notificacao) {
        Connection con = new DatabaseMySQL().getConnection();
        try {
            final String insert = "INSERT INTO notificacao (data, mensagem) values(?,?)";
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, notificacao.getData());
            pst.setString(2, notificacao.getMensagem());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NotificacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        return false;
    }
    
    public static boolean clear() {
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("delete from notificacao where id > 1");
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NotificacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return false;
    }
    
    public static ArrayList<Notificacao> listar() {
        ArrayList<Notificacao> allNotificacao = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from notificacao order by id desc");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Notificacao notificacao = new Notificacao();
                notificacao.setId(resultado.getInt("id"));
                notificacao.setData(resultado.getString("data"));
                notificacao.setMensagem(resultado.getString("mensagem"));
                allNotificacao.add(notificacao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotificacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allNotificacao;
    }
    
}
