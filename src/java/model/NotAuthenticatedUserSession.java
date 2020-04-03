/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author RudolfGumzej
 */
public class NotAuthenticatedUserSession {
    
    private int idNotAuthenticatedUserSession;
    private int notAuthenticatedUserId;
    private LocalDateTime sessionDate;
    private String ip_adress;

    public NotAuthenticatedUserSession() {
    }

    public NotAuthenticatedUserSession(int notAuthenticatedUserId, LocalDateTime sessionDate, String ip_adress) {
        this.notAuthenticatedUserId = notAuthenticatedUserId;
        this.sessionDate = sessionDate;
        this.ip_adress = ip_adress;
    }

    public NotAuthenticatedUserSession(int idNotAuthenticatedUserSession, int notAuthenticatedUserId, LocalDateTime sessionDate, String ip_adress) {
        this.idNotAuthenticatedUserSession = idNotAuthenticatedUserSession;
        this.notAuthenticatedUserId = notAuthenticatedUserId;
        this.sessionDate = sessionDate;
        this.ip_adress = ip_adress;
    }

    public int getIdNotAuthenticatedUserSession() {
        return idNotAuthenticatedUserSession;
    }

    public void setIdNotAuthenticatedUserSession(int idNotAuthenticatedUserSession) {
        this.idNotAuthenticatedUserSession = idNotAuthenticatedUserSession;
    }

    public int getNotAuthenticatedUserId() {
        return notAuthenticatedUserId;
    }

    public void setNotAuthenticatedUserId(int notAuthenticatedUserId) {
        this.notAuthenticatedUserId = notAuthenticatedUserId;
    }

    public LocalDateTime getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDateTime sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getIp_adress() {
        return ip_adress;
    }

    public void setIp_adress(String ip_adress) {
        this.ip_adress = ip_adress;
    }

    
    
}
