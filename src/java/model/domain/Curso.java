package model.domain;

import java.util.ArrayList;

/**
 *
 * @author junior
 */
public class Curso {
    private int id;
    private String nome;
    private String turno;
    private int codigouneb;
    private int qtdSemestre;
    private int cargaHoraria;
    private int creditacao;
    private int totalDisciplinaObrigatoria, totalDisciplinaOptativa;
    private int qtdMinSemestre, qtdMaxSemestre;
    private ArrayList<Disciplina> displinas;

    public Curso() {
    }
    
    public Curso(String nome, String turno, int codigouneb, int qtdSemestre, int cargaHoraria, int creditacao, int totalDisciplinaObrigatoria, int totalDisciplinaOptativa, int qtdMinSemestre, int qtdMaxSemestre) {
        this.nome = nome;
        this.turno = turno;
        this.codigouneb = codigouneb;
        this.qtdSemestre = qtdSemestre;
        this.cargaHoraria = cargaHoraria;
        this.creditacao = creditacao;
        this.totalDisciplinaObrigatoria = totalDisciplinaObrigatoria;
        this.totalDisciplinaOptativa = totalDisciplinaOptativa;
        this.qtdMinSemestre = qtdMinSemestre;
        this.qtdMaxSemestre = qtdMaxSemestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCodigouneb() {
        return codigouneb;
    }

    public void setCodigouneb(int codigouneb) {
        this.codigouneb = codigouneb;
    }

    public int getQtdSemestre() {
        return qtdSemestre;
    }

    public void setQtdSemestre(int qtdSemestre) {
        this.qtdSemestre = qtdSemestre;
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

    public int getTotalDisciplinaObrigatoria() {
        return totalDisciplinaObrigatoria;
    }

    public void setTotalDisciplinaObrigatoria(int totalDisciplinaObrigatoria) {
        this.totalDisciplinaObrigatoria = totalDisciplinaObrigatoria;
    }

    public int getTotalDisciplinaOptativa() {
        return totalDisciplinaOptativa;
    }

    public void setTotalDisciplinaOptativa(int totalDisciplinaOptativa) {
        this.totalDisciplinaOptativa = totalDisciplinaOptativa;
    }

    public int getQtdMinSemestre() {
        return qtdMinSemestre;
    }

    public void setQtdMinSemestre(int qtdMinSemestre) {
        this.qtdMinSemestre = qtdMinSemestre;
    }

    public int getQtdMaxSemestre() {
        return qtdMaxSemestre;
    }

    public void setQtdMaxSemestre(int qtdMaxSemestre) {
        this.qtdMaxSemestre = qtdMaxSemestre;
    }

    public ArrayList<Disciplina> getDisplinas() {
        return displinas;
    }

    public void setDisplinas(ArrayList<Disciplina> displinas) {
        this.displinas = displinas;
    }
    
}
