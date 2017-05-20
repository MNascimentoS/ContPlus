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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabaseMySQL;
import model.domain.ProcessoAdministrativo;

/**
 *
 * @author junior
 */
public class ProcessoAdmDAO {

    public ProcessoAdmDAO() {
    }
    
    public static boolean gravar(ProcessoAdministrativo processo){
        Connection con = new DatabaseMySQL().getConnection();
        try {
            final String insert = "INSERT INTO processo_administrativo(numero, motivo, aprovado, discente_usuario_id) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setInt(1, processo.getNumero());
            pst.setString(2, processo.getMotivo());
            pst.setBoolean(3, processo.isAprovado());
            pst.setInt(4, processo.getDiscente());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        return false;   
    }
    
    public static boolean jaExiste(ProcessoAdministrativo processo){
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        
        try{
          con = new DatabaseMySQL().getConnection();
          pst = con.prepareStatement("select * from processo_administrativo where numero=?");
          pst.setInt(1, processo.getNumero());
          rs = pst.executeQuery();
          //if exist true
          if(rs.next()){
            return true;
          }
        }catch(SQLException e){
          System.out.println("Erro ao tentar validar processo: "+ e);
        }
        return false;
    }
}
