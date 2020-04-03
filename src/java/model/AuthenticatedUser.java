/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author RudolfGumzej
 */
public class AuthenticatedUser {
     
    private int idAuthenticatedUser;
    private String name;
    private String surname;
    private String email;
    private String phone;
   private String adress;
   private String username;
   private String password;

    public AuthenticatedUser(String name, String surname, String email, String phone, String adress, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.username = username;
        this.password = password;
    }

    public AuthenticatedUser(int idAuthenticatedUser, String name, String surname, String email, String phone, String adress, String username, String password) {
        this.idAuthenticatedUser = idAuthenticatedUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.username = username;
        this.password = password;
    }

    
    public AuthenticatedUser() {
    }

    public int getIdAuthenticatedUser() {
        return idAuthenticatedUser;
    }

    public void setIdAuthenticatedUser(int idAuthenticatedUser) {
        this.idAuthenticatedUser = idAuthenticatedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
   

}
