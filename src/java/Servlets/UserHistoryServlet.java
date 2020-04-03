/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.ArticleHelper;
import BL.CartHelper;
import BL.CartItemHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;
import model.CartModel;

/**
 *
 * @author RudolfGumzej
 */
public class UserHistoryServlet extends HttpServlet {

      private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userId =Integer.valueOf(request.getParameter("userId"));
        List<AuthenticatedUserCart> carts = CART_HELPER.getCartForAuthenticatedUser(userId);
        List<AuthenticatedUserCart> carts1 = new ArrayList<>();
        for (AuthenticatedUserCart item : carts) {
            if (item.getPayed().equals("YES")) {
                
                carts1.add(item);
            }
            
        }
            String carts2 =new Gson().toJson(carts1);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(carts2);
            out.flush();
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int singleCartId =Integer.valueOf(request.getParameter("singleCartId"));
        List<AuthenticatedUserCartItem> items = CART_ITEM_HELPER.viewCartItemsForCart(singleCartId);
        AuthenticatedUserCart cart = CART_HELPER.viewAuthenticatedUserCart(singleCartId);
        List<CartModel> model = new ArrayList<CartModel>();
        
        for (AuthenticatedUserCartItem item : items) {
            
            CartModel cm = new CartModel();
            cm.setAmount(item.getAmount());
            Article a = ARTICLE_HELPER.getAricleById(item.getArticleId());
            cm.setName(a.getName());
            cm.setPrice(item.getPrice());
            cm.setTotalPrice(cart.getTotalPrice());
            
            model.add(cm);
        }
        
        
           String models =new Gson().toJson(model);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(models);
            out.flush();
        
        
    }

   
}
