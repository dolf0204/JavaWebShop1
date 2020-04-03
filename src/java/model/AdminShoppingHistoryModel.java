/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 *
 * @author RudolfGumzej
 */
public class AdminShoppingHistoryModel {
    
    private String username;
    private int idCart;
    private String paymentMethod;
    private LocalDateTime date;
    private double totalPrice;

    public AdminShoppingHistoryModel() {
    }

    public AdminShoppingHistoryModel(String username, String paymentMethod, LocalDateTime date, double totalPrice,int idCart) {
        this.username = username;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.totalPrice = totalPrice;
        this.idCart = idCart;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

   
    
    
    
}
