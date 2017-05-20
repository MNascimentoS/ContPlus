package model.domain;

import java.util.ArrayList;
import model.dao.CampusDAO;

/**
 *
 * @author junior
 */
public class Campus {
    private int id;
    private String nome;
    private String cidade;
    private ArrayList<Departamento> departamentos;

    public Campus() {
    }
    
    public Campus(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        departamentos = new ArrayList<>();
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Departamento getDepartamento(int index) {
        if (index <= departamentos.size()) return departamentos.get(index);
        else return null;
    }
    
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    public void addDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
    }
    
    public ArrayList<Campus> getAllFromDatabase() {
        return new CampusDAO().listar(CampusDAO.COMPLETE);
    }
    
}
