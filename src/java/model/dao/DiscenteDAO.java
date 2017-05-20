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
import model.database.DatabaseMySQL;
import model.domain.Discente;
import model.domain.ProcessoAdministrativo;

/**
 *
 * @author junior
 */
public class DiscenteDAO {

    public DiscenteDAO(){}

    public static boolean jaExiste(Discente discente) {
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = new DatabaseMySQL().getConnection();
            pst = con.prepareStatement("select * from discente where matricula=?");
            pst.setString(1, discente.getMatricula());
            rs = pst.executeQuery();
            //if exist true
            if (rs.next()) {
                discente.setId(rs.getInt("usuario_id"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar validar discente: " + e);
        }
        return false;
    }

}
