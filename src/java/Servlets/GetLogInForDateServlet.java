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
import model.AuthenticatedUserSession;
import model.LogInHistoryModel;
import model.SortLogInByDate;

/**
 *
 * @author RudolfGumzej
 */
public class GetLogInForDateServlet extends HttpServlet {

     private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();
    private static final UserHelper USER_HELPER = new UserHelper();
    
    private static final AuthenticatedSessionHelper SESSION_HELPER = new AuthenticatedSessionHelper();
  
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           
        int year = Integer.valueOf(request.getParameter("year"));
        int month =  Integer.valueOf(request.getParameter("month"));
        int day =  Integer.valueOf(request.getParameter("day"));
        List<LogInHistoryModel> historyDateList = new ArrayList<>();
           List<AuthenticatedUserSession> sessions = SESSION_HELPER.getAllAuthenticatedUserSessions();
          List<LogInHistoryModel> models = new ArrayList<>();
          
         
        
         for (AuthenticatedUserSession model : sessions) {
             if (model.getSessionDate().getYear() == year && model.getSessionDate().getMonthValue()== month && model.getSessionDate().getDayOfMonth()== day ) {
                 LogInHistoryModel lhm = new LogInHistoryModel();
                 lhm.setLogInDate(model.getSessionDate());
                 lhm.setUsername(model.getUsername());
                 lhm.setiPaddress(model.getIp_adress());
                 historyDateList.add(lhm);
             }
             
         }
        
        
            Collections.sort(historyDateList, new SortLogInByDate()); 
        
            String models2 =new Gson().toJson(historyDateList);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(models2);
            out.flush();
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    

}
