package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BL.UserHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AuthenticatedUser;

/**
 *
 * @author RudolfGumzej
 */
public class registrationServlet extends HttpServlet {

    
   private static final UserHelper USER_HELPER = new UserHelper();

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String name  = request.getParameter("name");
        String surname  = request.getParameter("surname");
        String phone  = request.getParameter("phone");
        String username  = request.getParameter("username");
        String password  = request.getParameter("password");
        String adress  = request.getParameter("adress");
        String email  = request.getParameter("email");
        

        AuthenticatedUser user = new AuthenticatedUser(name, surname, email, phone, adress, username, password);
        
        List<AuthenticatedUser> list = USER_HELPER.getAllUsers();
       boolean contains = false; 
       
        for (AuthenticatedUser list1 : list) {
            if (list1.getUsername().equals(user.getUsername())) {
                contains= true;
            }
        }
       
        if (contains) {
              response.sendRedirect("usernameExists.jsp");
        }
        
        else
        {
        int id =   USER_HELPER.insertUser(user);
       
        
        HttpSession session=request.getSession(true);  
        session.setAttribute("userID",id);  
        String uname = new Gson().toJson(user.getUsername());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(uname);
        out.flush();
        }
       // response.sendRedirect("registrationConfirmed.jsp");
        
    }

        
    }

  

