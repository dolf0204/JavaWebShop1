/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.ArticleHelper;
import BL.AuthenticatedSessionHelper;
import BL.CartHelper;
import BL.CartItemHelper;
import BL.UserHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminShoppingHistoryModel;
import model.AuthenticatedUser;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserSession;
import model.LogInHistoryModel;
import model.SortLogInByDate;
import model.SortUserInfoByUsername;
import model.SortUsersByUsername;

/**
 *
 * @author RudolfGumzej
 */
public class AdminLogInHistoryServlet extends HttpServlet {

    private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();
    private static final UserHelper USER_HELPER = new UserHelper();
    private List<LogInHistoryModel> models3;
    private static final AuthenticatedSessionHelper SESSION_HELPER = new AuthenticatedSessionHelper();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          String user = request.getParameter("user");
          AuthenticatedUser u = USER_HELPER.getUserByUsername(user);
          List<AuthenticatedUserSession> sessions = SESSION_HELPER.getAuthenticatedUserSession(u.getIdAuthenticatedUser());
          List<LogInHistoryModel> models = new ArrayList<>();
          
          for (AuthenticatedUserSession session : sessions) {
              LogInHistoryModel model = new LogInHistoryModel();
              model.setLogInDate(session.getSessionDate());
              model.setUsername(u.getUsername());
              model.setiPaddress(session.getIp_adress());
              
              models.add(model);
              
            
        }
          
          Collections.sort(models, new SortLogInByDate()); 
              String models2 =new Gson().toJson(models);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(models2);
            out.flush();
          
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            List<AuthenticatedUserSession> sessions = SESSION_HELPER.getAllAuthenticatedUserSessions();
          List<LogInHistoryModel> models = new ArrayList<>();
          
          for (AuthenticatedUserSession session : sessions) {
              LogInHistoryModel model = new LogInHistoryModel();
              model.setLogInDate(session.getSessionDate());
             
              model.setUsername(session.getUsername());
             // model.setUsername("test");
              model.setiPaddress(session.getIp_adress());
              
              models.add(model);
              
            
        }
          models3 = models;
          Collections.sort(models, new SortLogInByDate()); 
              String models2 =new Gson().toJson(models);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(models2);
            out.flush();
          
      
    }
  

   
}
