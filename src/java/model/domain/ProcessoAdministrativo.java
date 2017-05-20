package model.domain;

import model.dao.ProcessoAdmDAO;

/**
 *
 * @author junior
 */
public class ProcessoAdministrativo {
    private int numero;
    private String motivo;
    private boolean aprovado;
    private int discente;
    
    
    public ProcessoAdministrativo(int numero, String motivo, boolean aprovado) {
        this.numero = numero;
        this.motivo = motivo;
        this.aprovado = aprovado;
    }

    public int getDiscente() {
        return discente;
    }

    public void setDiscente(int discente) {
        this.discente = discente;
    }

   
    
    public ProcessoAdministrativo(){
        
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }
    
    public boolean jaExiste(){
        return ProcessoAdmDAO.jaExiste(this);
    }
    
    public boolean gravar(){
        return ProcessoAdmDAO.gravar(this);
    }
    
}
