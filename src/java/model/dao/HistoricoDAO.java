package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.database.DatabaseMySQL;
import model.domain.Historico;
import model.domain.Usuario;

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
    
    public static ArrayList<Historico> listar(){
        ArrayList<Historico> allHistorico = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from historico order by conta_codigo");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Historico historico = new Historico();
                historico.setId(resultado.getInt("id"));
                historico.setData(resultado.getString("data"));
                historico.setTipo(resultado.getString("tipo"));
                historico.setConta_codigo(resultado.getString("conta_codigo"));
                historico.setValor(resultado.getString("valor"));
                historico.setObservacao(resultado.getString("observacao"));
                allHistorico.add(historico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allHistorico;
    }
    
    public static ArrayList<Historico> listar(String dataI, String dataF){
        ArrayList<Historico> allHistorico = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from historico "
                    + "where STR_TO_DATE(data,'%d/%m/%Y') between STR_TO_DATE(?, '%d/%m/%Y') and STR_TO_DATE(?, '%d/%m/%Y')"
                    + "order by conta_codigo");
            pst.setString(1, dataI);
            pst.setString(2, dataF);
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Historico historico = new Historico();
                historico.setId(resultado.getInt("id"));
                historico.setData(resultado.getString("data"));
                historico.setTipo(resultado.getString("tipo"));
                historico.setConta_codigo(resultado.getString("conta_codigo"));
                historico.setValor(resultado.getString("valor"));
                historico.setObservacao(resultado.getString("observacao"));
                allHistorico.add(historico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allHistorico;
    }
}
