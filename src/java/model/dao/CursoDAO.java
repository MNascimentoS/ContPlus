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

/**
 *
 * @author mateus
 */
public class CursoDAO {
    
    public CursoDAO() {
    }
    
    public ArrayList<Curso> listar(int departamento, boolean... data) {
        ArrayList<Curso> allCurso = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from curso where departamento_id = " + departamento);
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Curso curso = new Curso();
                curso.setId(resultado.getInt("id"));
                curso.setNome(resultado.getString("nome"));
                curso.setCodigouneb(resultado.getInt("codigo_uneb"));
                curso.setTurno(resultado.getString("turno"));
                curso.setQtdSemestre(resultado.getInt("qtd_semestre"));
                curso.setCargaHoraria(resultado.getInt("carga_horaria"));
                curso.setCreditacao(resultado.getInt("creditacao"));
                curso.setTotalDisciplinaObrigatoria(resultado.getInt("total_disciplinas_obrigatorias"));
                curso.setTotalDisciplinaOptativa(resultado.getInt("total_disciplinas_optativas"));
                curso.setQtdMinSemestre(resultado.getInt("qtd_min_semestre"));
                curso.setQtdMaxSemestre(resultado.getInt("qtd_max_semestre"));
                allCurso.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allCurso;
    }
    
}
