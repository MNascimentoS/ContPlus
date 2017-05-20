package model.domain;

import model.dao.UsuarioDAO;

/**
 *
 * @author junior
 */
public class CoordenadorDeCurso extends Usuario{

    public CoordenadorDeCurso(String nome, String login, String senha, String tipo, int id, int foto) {
        super(nome, login, senha, tipo, id, foto);
    }

    public CoordenadorDeCurso() { 
    }
    
    public CoordenadorDeCurso(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public boolean insert() {
        return new UsuarioDAO().insert(this, "coord de curso");
    }
   
}
