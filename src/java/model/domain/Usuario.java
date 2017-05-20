package model.domain;

import java.util.ArrayList;
import model.dao.UsuarioDAO;

/**
 * Esta classe é a representacao generalista de um usuário
 * @author junior
 */
public class Usuario {
    protected String nome;
    protected String login;
    protected String senha;
    protected String tipo;
    protected int id;
    protected int foto;
    protected boolean valido;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha, String tipo, int id, int foto) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        this.id = id;
        this.foto = foto;
    }
    //metodos comum a todos os usuarios vao aqui
    //public abstract boolean autenticar();
	
	//public abstract boolean insert();    

    public Usuario(){}    
    /*
    * Core methods
    */
    
    public static ArrayList<Usuario> listar() {
        return UsuarioDAO.listar();
    }
    
    public void autenticar(){
        UsuarioDAO.validar(this);
    }
    /**
     * gets and sets
     * @return nome do usuario
     */
    public boolean eValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }
    
    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
