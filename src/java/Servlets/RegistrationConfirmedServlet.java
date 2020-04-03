/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.UserHelper;
import com.google.gson.Gson;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.ejb.SessionContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import model.AuthenticatedUser;

/**
 *
 * @author RudolfGumzej
 */
public class RegistrationConfirmedServlet extends HttpServlet {

    private static final UserHelper USER_HELPER = new UserHelper();

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session=request.getSession(false);  
         int id=(Integer)session.getAttribute("userID"); 
        AuthenticatedUser user = USER_HELPER.getUser(id);
      
        
        String username = new Gson().toJson(user.getUsername());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(username);
        out.flush();
        // response.getWriter().write(user.getUsername());
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
    }

}
