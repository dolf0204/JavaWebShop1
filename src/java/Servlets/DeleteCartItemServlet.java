/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.CartHelper;
import BL.CartItemHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;

/**
 *
 * @author RudolfGumzej
 */
public class DeleteCartItemServlet extends HttpServlet {

   
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final CartHelper CART_HELPER = new CartHelper();

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.valueOf(request.getParameter("id"));
        
        AuthenticatedUserCartItem auci = CART_ITEM_HELPER.viewAuthenticatedCartItem(id);
        int cartId = auci.getAuthenticatedUserCartId();
        AuthenticatedUserCart auc = CART_HELPER.viewAuthenticatedUserCart(cartId);
        auc.setTotalPrice(auc.getTotalPrice()-auci.getPrice());
        CART_HELPER.updateAuthenticatedUserCart(auc, cartId);
        
        
        CART_ITEM_HELPER.deleteAuthenticatedCartItem(id);
        String succes = "Succesefully deleted";
         String succes1 =new Gson().toJson(succes);
        
           PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(succes1);
            out.flush();
    }

   

}
