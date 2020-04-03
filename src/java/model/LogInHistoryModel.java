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
public class LogInHistoryModel {
    
    private String username;
    private String iPaddress;
    private LocalDateTime logInDate;

    public LogInHistoryModel() {
    }

    public LogInHistoryModel(String username, String iPaddress, LocalDateTime logInDate) {
        this.username = username;
        this.iPaddress = iPaddress;
        this.logInDate = logInDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getiPaddress() {
        return iPaddress;
    }

    public void setiPaddress(String iPaddress) {
        this.iPaddress = iPaddress;
    }

    public LocalDateTime getLogInDate() {
        return logInDate;
    }

    public void setLogInDate(LocalDateTime logInDate) {
        this.logInDate = logInDate;
    }
    
    
    
}
