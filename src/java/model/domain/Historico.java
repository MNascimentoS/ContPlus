package model.domain;

import java.util.ArrayList;
import model.dao.HistoricoDAO;

/**
 *
 * @author mateus
 */
public class Historico {
    private int id;
    private boolean showed;
    private String conta_codigo, tipo, data, observacao, valor;

    public Historico() {
    }

    public Historico(int id, String conta_codigo, String tipo, String data, String historico, String valor) {
        this.id = id;
        this.conta_codigo = conta_codigo;
        this.tipo = tipo;
        this.data = data;
        this.observacao = historico;
        this.valor = valor;
    }

    public Historico(String conta_codigo, String tipo, String data, String historico, String valor) {
        this.conta_codigo = conta_codigo;
        this.tipo = tipo;
        this.data = data;
        this.observacao = historico;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConta_codigo() {
        return conta_codigo;
    }

    public void setConta_codigo(String conta_codigo) {
        this.conta_codigo = conta_codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public boolean isAtivo() {
        return this.conta_codigo.charAt(0) == '1';
    }
    
    public boolean isPassivo() {
        return this.conta_codigo.charAt(0) == '2';
    }

    public boolean wasShowerd() {
        return showed;
    }

    public void setShowed(boolean showed) {
        this.showed = showed;
    }
    
    

    @Override
    public String toString() {
        return "Historico{" + "id=" + id + ", conta_codigo=" + conta_codigo + ", tipo=" + tipo + ", data=" + data + ", observacao=" + observacao + ", valor=" + valor + '}';
    }
    
    public boolean insert(){
        return HistoricoDAO.insert(this);
    }
    
    public static ArrayList<Historico> getAllFromDatabase(){
        return HistoricoDAO.listar();
    }
    
}
