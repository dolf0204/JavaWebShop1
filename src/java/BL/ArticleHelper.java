/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.List;
import model.AuthenticatedUser;
import model.Article;

/**
 *
 * @author RudolfGumzej
 */
public class ArticleHelper extends HandlerBase{
    
     public Article getAricle(String name) {
        return repository.getArticle(name);        
    }
     public Article getAricleById(int id) {
        return repository.getArticleById(id);        
    }
       public List<Article> getAllAricles() {
        return repository.getAllArticles();        
    }
}
