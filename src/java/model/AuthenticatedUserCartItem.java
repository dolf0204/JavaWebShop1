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
public class AuthenticatedUserCartItem {
    
    private int idAuthenticatedCartItem;
    private int authenticatedUserCartId;
    private int articleId;
    private int amount;
    private double price;

    public AuthenticatedUserCartItem() {
    }

    public AuthenticatedUserCartItem(int authenticatedUserCartId, int articleId, int amount, double price) {
        this.authenticatedUserCartId = authenticatedUserCartId;
        this.articleId = articleId;
        this.amount = amount;
        this.price = price;
    }

    public AuthenticatedUserCartItem(int idAuthenticatedCartItem, int authenticatedUserCartId, int articleId, int amount, double price) {
        this.idAuthenticatedCartItem = idAuthenticatedCartItem;
        this.authenticatedUserCartId = authenticatedUserCartId;
        this.articleId = articleId;
        this.amount = amount;
        this.price = price;
    }

    public int getIdAuthenticatedCartItem() {
        return idAuthenticatedCartItem;
    }

    public void setIdAuthenticatedCartItem(int idAuthenticatedCartItem) {
        this.idAuthenticatedCartItem = idAuthenticatedCartItem;
    }

    public int getAuthenticatedUserCartId() {
        return authenticatedUserCartId;
    }

    public void setAuthenticatedUserCartId(int authenticatedUserCartId) {
        this.authenticatedUserCartId = authenticatedUserCartId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
