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
import model.domain.Semestre;

/**
 *
 * @author mateus
 */
public class SemestreDAO {
    
    public SemestreDAO() {
    }
    
    public static boolean update(Semestre semestre) {
        Connection con = new DatabaseMySQL().getConnection();
        try {
            final String update = "Update semestre set cancelado = ? where ano = ? and semestre = ?";
            PreparedStatement pst = con.prepareStatement(update);
            pst.setBoolean(1, semestre.isCancelado());
            pst.setInt(2, semestre.getAno());
            pst.setInt(3, semestre.getSemestre());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SemestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        return false;
    }
    
    public ArrayList<Semestre> listar(){
        ArrayList<Semestre> allSemestre = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from semestre");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Semestre semestre = new Semestre();
                semestre.setId(resultado.getInt("id"));
                semestre.setAno(resultado.getInt("ano"));
                semestre.setSemestre(resultado.getInt("semestre"));
                semestre.setCancelado(resultado.getBoolean("cancelado"));
                allSemestre.add(semestre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allSemestre;
    }
}
