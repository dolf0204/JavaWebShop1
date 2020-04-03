/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.CartHelper;
import BL.CartItemHelper;
import BL.UserHelper;
import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;
import java.time.LocalDateTime;
import java.util.Hashtable;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AuthenticatedUser;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;

/**
 *
 * @author RudolfGumzej
 */
public class FinishPaymentServlet extends HttpServlet {

  

     private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final UserHelper USER_HELPER = new UserHelper();
   private int id;
   private double amount;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
          String amount1 = new Gson().toJson(amount);
         PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(amount1);
        out.flush();
        
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           HttpSession cartSession=request.getSession(false);  
        String cartItemId=(String)cartSession.getAttribute("cartID"); 
        Integer cartIId = Integer.valueOf(cartItemId);
        String paymentOption =request.getParameter("group");
        Integer userID = Integer.valueOf(request.getParameter("id"));
        id = userID;
       
        AuthenticatedUserCart cart = CART_HELPER.viewAuthenticatedUserCart(cartIId);
        cart.setShoppingDate(LocalDateTime.now());
        cart.setPayed("YES");
        cart.setPaymentOption(paymentOption);
        
        
        CART_HELPER.updateAuthenticatedUserCart(cart, cartIId);
        amount = cart.getTotalPrice();
        if (id == 1) {
             response.sendRedirect("anonimusPaymentConfirmed.jsp");
            
        }
        else
        {
        sendMail();
        
            if (paymentOption.equals("payPal")) {
                
                 HttpSession amountSession=request.getSession(true);  
            amountSession.setAttribute("amount",cart.getTotalPrice());  
                response.sendRedirect("payWithPayPal.jsp");
            }
            else
            {
               response.sendRedirect("paymentConfirmed.jsp");

            }
        
        }
       
    }
    
       public void sendMail() throws IOException
   {
       
           
       
     AuthenticatedUser user = USER_HELPER.getUser(id);
       
       
     String  host = "smtp.gmail.com";
     String  port = "465";
     String  ssl_factory = "javax.net.ssl.SSLSocketFactory";
     final String from = "rudigum@gmail.com";
      String to = user.getEmail();
      String user_name = user.getEmail();
     final String pass = "Kleopatra1";
     
      Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
      Properties prop = new Properties();
      prop.put("mail.smtp.host", host);
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.debug", "true");
      prop.put("mail.smtp.port", port);
      prop.put("mail.smtp.socketFactory.port", port);
      prop.put("mail.smtp.socketFactory.class", ssl_factory);
      prop.put("mail.smtp.socketFactory.fallback", "true");
      prop.put("mail.smtp.user",user_name);
     
     
      Session ses = Session.getInstance(prop,
             new javax.mail.Authenticator(){
         protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
            return new javax.mail.PasswordAuthentication(from,pass);
         }
      } );
     
      ses.setDebug(true);
     
      MimeMessage msg = new MimeMessage(ses);
     
      try
      {
        
         msg.setFrom(new InternetAddress(from));
         msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
         msg.setSubject("New purchase");
         msg.setText("Your purchase has been confirmed, delivery is expected within 3 days");
         Transport.send(msg);
      }
      catch(Exception ex2)
      {
            ex2.printStackTrace();
            System.out.println(ex2);
      }
   }

    
}
