/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.NotificacaoDAO;

/**
 *
 * @author mateus
 */
public class Notificacao {
    
    int id;
    String data;
    String mensagem;
    
    public static final int ERRO_404 = 0;
    public static final int ERRO_500 = 1;
    
    private static final String ERRO_404_MESSAGE = "Foi gerado um erro 404.";
    private static final String ERRO_500_MESSAGE = "Foi gerado um erro 500.";
    
    public Notificacao() {
    }
    
    private void configureCurrentTime() {
        data = Calendar.getInstance().getTime().toString();
    }
    
    public boolean informError(int error) {
        configureCurrentTime();
        switch(error) {
            case ERRO_404: this.mensagem = ERRO_404_MESSAGE;
                break;
            case ERRO_500: this.mensagem = ERRO_500_MESSAGE;
                break;
        }
        return insert();
    }
    
    public boolean informMessage(String mensagem) {
        configureCurrentTime();
        this.mensagem = mensagem;
        return insert();
    }

    private boolean insert() {
        return NotificacaoDAO.insert(this);
    }
    
    public static boolean clear() {
        return NotificacaoDAO.clear();
    }
    
    public ArrayList<Notificacao> getAllFromDatabase() {
        return NotificacaoDAO.listar();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }
    
    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    
    public String getDaysFromNow() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(data));
        } catch (ParseException ex) {
            Logger.getLogger(Notificacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int days = daysBetween(new Date(), cal.getTime());
        switch (days) {
            case 0:
                return "Hoje";
            case -1:
                return "Ontem";
            default:
                return "Faz " + (-days) + " dias";
        }        
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
}
