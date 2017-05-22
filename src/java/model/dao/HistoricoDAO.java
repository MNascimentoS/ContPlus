package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabaseMySQL;
import model.domain.Historico;

/**
 *
 * @author mateus
 */
public class HistoricoDAO {
    public static boolean insert(Historico lancamento) {
        Connection con = new DatabaseMySQL().getConnection();
        try {
            final String insert = "INSERT INTO historico (data, tipo, conta_codigo, valor, observacao) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, lancamento.getData());
            pst.setString(2, lancamento.getTipo());
            pst.setString(3, lancamento.getConta_codigo());
            pst.setString(4, lancamento.getValor());
            pst.setString(5, lancamento.getObservacao());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        return false;
    }
}
