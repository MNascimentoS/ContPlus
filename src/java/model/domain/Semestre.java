/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.ArrayList;
import model.dao.SemestreDAO;

/**
 *
 * @author junior
 */
public class Semestre {
    private int id;
    private int ano;
    private int semestre;
    private boolean cancelado;

    public Semestre(){
    }
    
    public Semestre(int id, int ano, int semestre, boolean cancelado) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.cancelado = cancelado;
    }
    
    public Semestre(int ano, int semestre, boolean cancelado) {
        this.ano = ano;
        this.semestre = semestre;
        this.cancelado = cancelado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    
    public boolean update() {
        return SemestreDAO.update(this);
    }
    
    @Override
    public String toString() {
        return ano + "." + semestre;
    }
    
    public ArrayList<Semestre> getAllFromDatabase() {
        return new SemestreDAO().listar();
    }
            
}
