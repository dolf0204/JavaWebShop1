/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.CartHelper;
import BL.CartItemHelper;
import BL.UserHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
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
public class CategoryCartServlet extends HttpServlet {

   private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private int cartId;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int amount =Integer.valueOf(request.getParameter("amount"));
        int userId =Integer.valueOf(request.getParameter("userId"));
        double price = Double.valueOf(request.getParameter("price"));
        int articleID =Integer.valueOf(request.getParameter("articleID"));
        String category = request.getParameter("category");
        
        if (cartId == 0) {
            
            AuthenticatedUserCart cart = new AuthenticatedUserCart();
            cart.setAuthanticatedUserId(userId);
            cart.setAuthanticatedUserSessionId(1);
            cart.setPaymentOption("Delivery");
            cart.setShoppingDate(LocalDateTime.now());
            double price1 = round(price,2);
            cart.setTotalPrice(round(price1,2) * amount);
            
            cartId =  CART_HELPER.insertAuthenticatedUserCart(cart);
            
           
        }
        else
        {
            AuthenticatedUserCart cart = CART_HELPER.viewAuthenticatedUserCart(cartId);
            cart.setTotalPrice(cart.getTotalPrice()+amount*price);
            CART_HELPER.updateAuthenticatedUserCart(cart, cartId);
        }
        
         AuthenticatedUserCartItem cartItem = new AuthenticatedUserCartItem();
            cartItem.setAmount(amount);
            cartItem.setArticleId(articleID);
            cartItem.setAuthenticatedUserCartId(cartId);
            double price1 = round(price,2);
            cartItem.setPrice(price1*amount);
            
            int cartItemId = CART_ITEM_HELPER.insertAuthenticatedUserCartItem(cartItem);
            
            response.sendRedirect(category);

    }
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}

   
}
