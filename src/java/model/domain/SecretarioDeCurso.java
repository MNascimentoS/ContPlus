/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;
import model.dao.UsuarioDAO;

/**
 *
 * @author junior
 */
public class SecretarioDeCurso extends Usuario{

	public SecretarioDeCurso() {
    }

	public SecretarioDeCurso(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public SecretarioDeCurso(String nome, String login, String senha, String tipo, int id, int foto) {
        super(nome, login, senha, tipo, id, foto);
    }

    public boolean insert() {
        return new UsuarioDAO().insert(this, "secretario de curso");
    }
    
}
