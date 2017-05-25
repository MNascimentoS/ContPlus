package model.domain;

import java.util.ArrayList;
import model.dao.ContaDAO;

/**
 *
 * @author mateus
 */
public class Conta {
    private String codigo, nome;

    public Conta() {
    }
    
    public Conta(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean insert() {
        return ContaDAO.insert(this);
    }
    
    public void fillFromDatabase() {
        Conta conta = ContaDAO.select(this);
        this.codigo = conta.getCodigo();
        this.nome = conta.getNome();
    }
    
    public static ArrayList<Conta> getAllFromDatabase() {
        return ContaDAO.listar();
    }
}
