/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.AuthenticatedSessionHelper;
import BL.UserHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AuthenticatedUser;
import model.AuthenticatedUserSession;

/**
 *
 * @author RudolfGumzej
 */
public class LogInUserServlet extends HttpServlet {

    private static final UserHelper USER_HELPER = new UserHelper();
    private static final AuthenticatedSessionHelper A_SESSION_HELPER = new AuthenticatedSessionHelper();
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         Integer id =Integer.valueOf(request.getParameter("id"));
         AuthenticatedUser u = USER_HELPER.getUser(id);
         
             String user =new Gson().toJson(u);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(user);
            out.flush();
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       AuthenticatedUser user = USER_HELPER.logInUser(username,password);
       
        int user_id =Integer.parseInt(new Gson().toJson(user.getIdAuthenticatedUser()));
        
        
        String ip_adress =  request.getRemoteAddr();
//        String localAddres = request.getLocalAddr();
        
        AuthenticatedUserSession aus = new AuthenticatedUserSession(user_id, LocalDateTime.now(), ip_adress,user.getUsername());
        A_SESSION_HELPER.repository.insertAuthenticatedSession(aus);
        

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(user_id);
        out.flush();
        
       
    }

   

}
