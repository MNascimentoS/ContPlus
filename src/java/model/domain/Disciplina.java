/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author junior
 */
public class Disciplina {
    private String nome;
    private String tipoDisciplina;
    private int cargaHoraria;
    private int creditacao;
    private int semestre;
    private int codigo;
    private int prioridade;

    public Disciplina(String nome, String tipoDisciplina, int cargaHoraria, int creditacao, int semestre, int codigo, int prioridade) {
        this.nome = nome;
        this.tipoDisciplina = tipoDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.creditacao = creditacao;
        this.semestre = semestre;
        this.codigo = codigo;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDisciplina() {
        return tipoDisciplina;
    }

    public void setTipoDisciplina(String tipoDisciplina) {
        this.tipoDisciplina = tipoDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCreditacao() {
        return creditacao;
    }

    public void setCreditacao(int creditacao) {
        this.creditacao = creditacao;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }    
    
}
