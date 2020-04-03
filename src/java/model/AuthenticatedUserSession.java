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
public class AuthenticatedUserSession {
    
    private int idAuthenticatedUserSession;
    private int authenticatedUserId;
    private LocalDateTime sessionDate;
    private String ip_adress;
    private String username;

    public AuthenticatedUserSession() {
    }

    public AuthenticatedUserSession(int idAuthenticatedUserSession, int authenticatedUserId, LocalDateTime sessionDate, String ip_adress,String username) {
        this.idAuthenticatedUserSession = idAuthenticatedUserSession;
        this.authenticatedUserId = authenticatedUserId;
        this.sessionDate = sessionDate;
        this.ip_adress = ip_adress;
        this.username=username;
    }

    public AuthenticatedUserSession(int authenticatedUserId, LocalDateTime sessionDate, String ip_adress,String username) {
        this.authenticatedUserId = authenticatedUserId;
        this.sessionDate = sessionDate;
        this.ip_adress = ip_adress;
        this.username=username;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdAuthenticatedUserSession() {
        return idAuthenticatedUserSession;
    }

    public void setIdAuthenticatedUserSession(int idAuthenticatedUserSession) {
        this.idAuthenticatedUserSession = idAuthenticatedUserSession;
    }

    public int getAuthenticatedUserId() {
        return authenticatedUserId;
    }

    public void setAuthenticatedUserId(int authenticatedUserId) {
        this.authenticatedUserId = authenticatedUserId;
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
