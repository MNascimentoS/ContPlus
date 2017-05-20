package model.domain;

import model.dao.UsuarioDAO;

/**
 *
 * @author junior
 */
public class CoordenadorAcademico extends Usuario{

    public CoordenadorAcademico(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public boolean insert() {
        return new UsuarioDAO().insert(this, "coord acadêmico");
    }
    
}
