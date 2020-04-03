/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.ArticleHelper;
import BL.UserHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.AuthenticatedUser;

/**
 *
 * @author RudolfGumzej
 */
public class ProductsServlet extends HttpServlet {

      private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          String name=request.getParameter("name");
        Article article =ARTICLE_HELPER.getAricle(name);
        
        String article1 = new Gson().toJson(article);
        
        
        
         PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(article1);
        out.flush();
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
