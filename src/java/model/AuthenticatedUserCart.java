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
public class AuthenticatedUserCart {
    
    private int idCart;
    private int authanticatedUserId;
    private LocalDateTime shoppingDate;
    private double totalPrice;
    private int authanticatedUserSessionId;
    private String paymentOption;
    private String payed;

    public AuthenticatedUserCart() {
    }

    public AuthenticatedUserCart(int authanticatedUserId, LocalDateTime shoppingDate, double totalPrice, int authanticatedUserSessionId, String paymentOption,String payed) {
        this.authanticatedUserId = authanticatedUserId;
        this.shoppingDate = shoppingDate;
        this.totalPrice = totalPrice;
        this.authanticatedUserSessionId = authanticatedUserSessionId;
        this.paymentOption = paymentOption;
        this.payed = payed;
    }

    public AuthenticatedUserCart(int idCart, int authanticatedUserId, LocalDateTime shoppingDate, double totalPrice, int authanticatedUserSessionId, String paymentOption,String payed) {
        this.idCart = idCart;
        this.authanticatedUserId = authanticatedUserId;
        this.shoppingDate = shoppingDate;
        this.totalPrice = totalPrice;
        this.authanticatedUserSessionId = authanticatedUserSessionId;
        this.paymentOption = paymentOption;
        this.payed = payed;
    }

    public int getIdCart() {
        return idCart;
    }

    public String getPayed() {
        return payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getAuthanticatedUserId() {
        return authanticatedUserId;
    }

    public void setAuthanticatedUserId(int authanticatedUserId) {
        this.authanticatedUserId = authanticatedUserId;
    }

    public LocalDateTime getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(LocalDateTime shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAuthanticatedUserSessionId() {
        return authanticatedUserSessionId;
    }

    public void setAuthanticatedUserSessionId(int authanticatedUserSessionId) {
        this.authanticatedUserSessionId = authanticatedUserSessionId;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }
    
    
    
    
}
