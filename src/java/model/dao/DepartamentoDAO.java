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
import model.domain.Curso;
import model.domain.Departamento;

/**
 *
 * @author mateus
 */
public class DepartamentoDAO {
    
    public static final boolean COMPLETE = true;
    
    public DepartamentoDAO(){
    }
    
    public ArrayList<Departamento> listar(int campus, boolean... data) {
        ArrayList<Departamento> allDepartamento = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from departamento where campus_id = " + campus);
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(resultado.getInt("id"));
                departamento.setCodigo(resultado.getString("codigo"));
                departamento.setNome(resultado.getString("nome"));
                for (boolean request : data) {
                    if (request == COMPLETE) {
                        ArrayList<Curso> allCursos = new CursoDAO().listar(departamento.getId());
                        departamento.setCursos(allCursos);
                        break;
                    }
                }
                allDepartamento.add(departamento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allDepartamento;
    }
}
