package model.domain;

import java.util.ArrayList;
import model.dao.DiscenteDAO;

/**
 *
 * @author junior
 */
public class Discente extends Usuario{
    private String matricula;
    private String contato;
    private String formaDeIngresso;
    private int cargaHorariaCumprida, cargaHorariaEmCurso, cargaHorariaACC;
    private int creditacao, creditacaoEmCurso;
    private int totalSemestreTrancados;
    private int totalDisciplinaObrigatoria, totalDisciplinaOptativa;
    private boolean semestralizado;
    private Semestre semestreAtual, semestreDeIngresso;
    private ArrayList<Semestre> semestrestracados;
    private ArrayList<ProcessoAdministrativo> processoAdministrativos;
    private ArrayList<Disciplina> disciplinasEmCurso, disciplinasConcluidas;


    public Discente() {
    }

    public Discente(String nome, String login, String senha) {
        super(nome, login, senha);
    }

	public Discente(String nome, String login, String senha, String tipo, int id, int foto) {
        super(nome, login, senha, tipo, id, foto);
    }

    public boolean insert() {
        return false;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getFormaDeIngresso() {
        return formaDeIngresso;
    }

    public void setFormaDeIngresso(String formaDeIngresso) {
        this.formaDeIngresso = formaDeIngresso;
    }

    public int getCargaHorariaCumprida() {
        return cargaHorariaCumprida;
    }

    public void setCargaHorariaCumprida(int cargaHorariaCumprida) {
        this.cargaHorariaCumprida = cargaHorariaCumprida;
    }

    public int getCargaHorariaEmCurso() {
        return cargaHorariaEmCurso;
    }

    public void setCargaHorariaEmCurso(int cargaHorariaEmCurso) {
        this.cargaHorariaEmCurso = cargaHorariaEmCurso;
    }

    public int getCargaHorariaACC() {
        return cargaHorariaACC;
    }

    public void setCargaHorariaACC(int cargaHorariaACC) {
        this.cargaHorariaACC = cargaHorariaACC;
    }

    public int getCreditacao() {
        return creditacao;
    }

    public void setCreditacao(int creditacao) {
        this.creditacao = creditacao;
    }

    public int getCreditacaoEmCurso() {
        return creditacaoEmCurso;
    }

    public void setCreditacaoEmCurso(int creditacaoEmCurso) {
        this.creditacaoEmCurso = creditacaoEmCurso;
    }

    public int getTotalSemestreTrancados() {
        return totalSemestreTrancados;
    }

    public void setTotalSemestreTrancados(int totalSemestreTrancados) {
        this.totalSemestreTrancados = totalSemestreTrancados;
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

    public boolean isSemestralizado() {
        return semestralizado;
    }

    public void setSemestralizado(boolean semestralizado) {
        this.semestralizado = semestralizado;
    }

    public Semestre getSemestreAtual() {
        return semestreAtual;
    }

    public void setSemestreAtual(Semestre semestreAtual) {
        this.semestreAtual = semestreAtual;
    }

    public Semestre getSemestreDeIngresso() {
        return semestreDeIngresso;
    }

    public void setSemestreDeIngresso(Semestre semestreDeIngresso) {
        this.semestreDeIngresso = semestreDeIngresso;
    }

    public ArrayList<Semestre> getSemestrestracados() {
        return semestrestracados;
    }

    public void setSemestrestracados(ArrayList<Semestre> semestrestracados) {
        this.semestrestracados = semestrestracados;
    }

    public ArrayList<ProcessoAdministrativo> getProcessoAdministrativos() {
        return processoAdministrativos;
    }

    public void setProcessoAdministrativos(ArrayList<ProcessoAdministrativo> processoAdministrativos) {
        this.processoAdministrativos = processoAdministrativos;
    }

    public ArrayList<Disciplina> getDisciplinasEmCurso() {
        return disciplinasEmCurso;
    }

    public void setDisciplinasEmCurso(ArrayList<Disciplina> disciplinasEmCurso) {
        this.disciplinasEmCurso = disciplinasEmCurso;
    }

    public ArrayList<Disciplina> getDisciplinasConcluidas() {
        return disciplinasConcluidas;
    }

    public void setDisciplinasConcluidas(ArrayList<Disciplina> disciplinasConcluidas) {
        this.disciplinasConcluidas = disciplinasConcluidas;
    }
    
    public boolean existe(){
        return DiscenteDAO.jaExiste(this);
    }

    @Override
    public String toString() {
        return "Discente{" + "matricula=" + matricula + ", contato=" + contato + ", formaDeIngresso=" + formaDeIngresso + ", cargaHorariaCumprida=" + cargaHorariaCumprida + ", cargaHorariaEmCurso=" + cargaHorariaEmCurso + ", cargaHorariaACC=" + cargaHorariaACC + ", creditacao=" + creditacao + ", creditacaoEmCurso=" + creditacaoEmCurso + ", totalSemestreTrancados=" + totalSemestreTrancados + ", totalDisciplinaObrigatoria=" + totalDisciplinaObrigatoria + ", totalDisciplinaOptativa=" + totalDisciplinaOptativa + ", semestralizado=" + semestralizado + ", semestreAtual=" + semestreAtual + ", semestreDeIngresso=" + semestreDeIngresso + ", semestrestracados=" + semestrestracados + ", processoAdministrativos=" + processoAdministrativos + ", disciplinasEmCurso=" + disciplinasEmCurso + ", disciplinasConcluidas=" + disciplinasConcluidas + '}';
    }
    
}
