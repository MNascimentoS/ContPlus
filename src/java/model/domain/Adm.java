package model.domain;

/**
 * Esta classe é a representa o usuario adm que tem a obrigacao de cadastrar
 * os usuarios: coordenadores e secretarios.
 * @author junior
 */
public class Adm extends Usuario{

	public Adm() {
        super(null, null, null);
    }

    public Adm(String nome, String login, String senha, String tipo, int id, int foto) {
        super(nome, login, senha, tipo, id, foto);
    }

	public Adm(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public boolean insert() {
        return false;
    }
    
    //todos os metodos pertencentes ao adm vao aqui
    public void cadastrarCoordenador(){}
}
