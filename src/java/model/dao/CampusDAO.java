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
import model.domain.Campus;
import model.domain.Departamento;
import model.dao.DepartamentoDAO;

/**
 *
 * @author mateus
 */
public class CampusDAO {
    
    public static final boolean COMPLETE = true;
    
    public CampusDAO() {
    }
    
    public ArrayList<Campus> listar(boolean...  data) {
        ArrayList<Campus> allCampus = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from campus");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Campus campus = new Campus();
                campus.setId(resultado.getInt("id"));
                campus.setNome(resultado.getString("nome"));
                campus.setCidade(resultado.getString("cidade"));
                for (boolean request : data) {
                    if (request == COMPLETE) {
                        ArrayList<Departamento> allDepartamentos;
                        allDepartamentos = new DepartamentoDAO().listar(campus.getId(), DepartamentoDAO.COMPLETE);
                        campus.setDepartamentos(allDepartamentos);
                    }
                }
                allCampus.add(campus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allCampus;
    }
}
