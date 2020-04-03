/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.ArticleHelper;
import BL.CartHelper;
import BL.CartItemHelper;
import BL.UserHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AuthenticatedUser;

/**
 *
 * @author RudolfGumzej
 */
public class AdminGetUserInfoServlet extends HttpServlet {
    
     private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();
    private static final UserHelper USER_HELPER = new UserHelper();


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           String user = request.getParameter("user");
         AuthenticatedUser u = USER_HELPER.getUserByUsername(user);
         
              String user1 =new Gson().toJson(u);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(user1);
            out.flush();
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
}
