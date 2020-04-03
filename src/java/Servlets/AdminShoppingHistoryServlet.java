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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminShoppingHistoryModel;
import model.Article;
import model.AuthenticatedUser;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;
import model.CartModel;
import model.SortUsersByUsername;

/**
 *
 * @author RudolfGumzej
 */
public class AdminShoppingHistoryServlet extends HttpServlet {

    
   private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();
    private static final UserHelper USER_HELPER = new UserHelper();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           List<AuthenticatedUserCart> carts = CART_HELPER.viewAllAuthenticatedUserCart();
        List<AdminShoppingHistoryModel> models = new ArrayList<>();
        
        for (AuthenticatedUserCart item : carts) {
            if (item.getPayed().equals("YES")) {
                
                AdminShoppingHistoryModel model = new AdminShoppingHistoryModel();
                model.setDate(item.getShoppingDate());
                model.setPaymentMethod(item.getPaymentOption());
                model.setTotalPrice(item.getTotalPrice());
               model.setIdCart(item.getIdCart());
                
                if (item.getAuthanticatedUserId() != 1) {
                      AuthenticatedUser user = USER_HELPER.getUser(item.getAuthanticatedUserId());
                         model.setUsername(user.getUsername());
               
                        models.add(model);
                }
              
            }
            
        }
            Collections.sort(models, new SortUsersByUsername()); 
        
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
        
          int idCart = Integer.valueOf(request.getParameter("id"));
          AuthenticatedUserCart cart = CART_HELPER.viewAuthenticatedUserCart(idCart);
          List<AuthenticatedUserCartItem> items = CART_ITEM_HELPER.viewCartItemsForCart(idCart);
          List<CartModel> models = new ArrayList<CartModel>();
          for (AuthenticatedUserCartItem item : items) {
            CartModel model = new CartModel();
            model.setAmount(item.getAmount());
            Article a = ARTICLE_HELPER.getAricleById(item.getArticleId());
            model.setName(a.getName());
            model.setPrice(item.getPrice());
            model.setTotalPrice(cart.getTotalPrice());
            
            models.add(model);
        }
          
            String models2 =new Gson().toJson(models);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(models2);
            out.flush();
      
          
       
    }

   
}
