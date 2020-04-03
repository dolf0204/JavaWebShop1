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
public class Article {
    
    private int idArticle;
    private String name;
    private int categoryId;
    private double price;
    private String description;
    private String picturePath;


    public Article(int idArticle, String name, int categoryId, double price, String description,String picturePath) {
        this.idArticle = idArticle;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.description = description;
        this.picturePath = picturePath;
    }

    public Article(String name, int categoryId, double price, String description,String picturePath) {
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.description = description;
        this.picturePath = picturePath;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Article() {
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
