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
import model.domain.Usuario;

/**
 *
 * @author mateus
 */
public class UsuarioDAO {
    
    public UsuarioDAO() {
    }
    
    public static boolean insert(Usuario usuario) {
        usuario.toString();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            final String insert = "INSERT INTO usuario (nome, email, senha, tipo) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getTipo());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        return false;
    }
    
    public static ArrayList<Usuario> listar(){
        ArrayList<Usuario> allUsuario = new ArrayList();
        Connection con = new DatabaseMySQL().getConnection();
        try {
            PreparedStatement pst = con.prepareStatement("select * from usuario");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("idusuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setTipo(resultado.getString("tipo"));
                usuario.setFoto(resultado.getInt("foto"));
                allUsuario.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            new DatabaseMySQL().desconnect(con);
        }
        
        return allUsuario;
    }
    
    public static boolean validar(Usuario usuario){
        usuario.setValido(false);
        PreparedStatement pst = null;
        Connection con = null;
        ResultSet rs = null;
        System.out.println("tipo: "+usuario.getEmail());
        System.out.println("tipo: "+usuario.getSenha());
        try{
          con = new DatabaseMySQL().getConnection();
          pst = con.prepareStatement("select * from usuario where email=? and senha=?");
          pst.setString(1, usuario.getEmail());
          pst.setString(2, usuario.getSenha()); 
          rs = pst.executeQuery();
          //if the user exists
          if(rs.next()){
              System.out.println("entrei");
            usuario.setId(rs.getInt("idusuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setTipo(rs.getString("tipo"));
            usuario.setValido(true);
          }
        }catch(SQLException e){
          System.out.println("Erro ao tentar validar: "+ e);
        }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException e){
                }
            }
            if(pst != null){
                try{
                  pst.close();
                }catch(SQLException e){
                }
            }
            if(rs != null){
                try{
                   rs.close();
                }catch(SQLException e){
                }
            }
        }
        return usuario.eValido();
    }
}
