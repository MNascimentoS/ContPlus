package model.domain;

import java.util.ArrayList;
import model.dao.UsuarioDAO;

/**
 * Esta classe é a representacao generalista de um usuário
 * @author junior
 */
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String tipo;
    private int id;
    private int foto;
    private boolean valido;

    public Usuario() {}

    public Usuario(String nome, String email, String senha, String tipo, int id, int foto, boolean valido) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.id = id;
        this.foto = foto;
        this.valido = valido;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean eValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    public void autenticar(){
        UsuarioDAO.validar(this);
    }
    
    public static ArrayList<Usuario> listar() {
        return UsuarioDAO.listar();
    }
    
}
