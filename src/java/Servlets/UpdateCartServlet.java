/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.ArticleHelper;
import BL.CartHelper;
import BL.CartItemHelper;
import static Servlets.CartServlet.round;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;

/**
 *
 * @author RudolfGumzej
 */
public class UpdateCartServlet extends HttpServlet {

     private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();
    private double totalPrice;
   private AuthenticatedUserCart ausc;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double totPrice = Double.valueOf(request.getParameter("totPrice"));
        ausc.setTotalPrice(totPrice);
       CART_HELPER.updateAuthenticatedUserCart(ausc, ausc.getIdCart());
    }

   
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idCartItem =Integer.valueOf(request.getParameter("idCartItem"));
         int amount = Integer.valueOf(request.getParameter("amount"));
         double pricePerItem = Double.valueOf(request.getParameter("pricePerItem"));
         double totPrice = Double.valueOf(request.getParameter("totPrice"));
        
        
        AuthenticatedUserCartItem auci = CART_ITEM_HELPER.viewAuthenticatedCartItem(idCartItem);
        
        auci.setAmount(amount);
     double price =  round(amount*pricePerItem,2);
         auci.setPrice(price);
        AuthenticatedUserCart auc = CART_HELPER.viewAuthenticatedUserCart(auci.getAuthenticatedUserCartId());
        ausc = auc;
        
        //totalPrice += round(price,2);
        auc.setTotalPrice(round(totPrice,2));
        CART_ITEM_HELPER.updateAuthenticatedUserCartItem(auci, idCartItem);
        CART_HELPER.updateAuthenticatedUserCart(auc, auc.getIdCart());
        
             String price1 =new Gson().toJson(totalPrice);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(price1);
            out.flush();
        
    }

    

}
