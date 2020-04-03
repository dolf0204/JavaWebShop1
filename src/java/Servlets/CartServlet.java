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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Article;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;
import model.CartModel;

/**
 *
 * @author RudolfGumzej
 */
public class CartServlet extends HttpServlet {

   private static final CartHelper CART_HELPER = new CartHelper();
   private static final CartItemHelper CART_ITEM_HELPER = new CartItemHelper();
   private static final ArticleHelper ARTICLE_HELPER = new ArticleHelper();

   private int cartId;
   private double totalPrice;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (cartId == 0) {
            
            List<String> result = new ArrayList<String>();
            result.add("No items in cart yet");
            String result1 =new Gson().toJson(result);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(result1);
            out.flush();
        }
        else
        {
            List<AuthenticatedUserCartItem> items = CART_ITEM_HELPER.viewCartItemsForCart(cartId);
            List<CartModel> list = new ArrayList<>();
            AuthenticatedUserCart auc = CART_HELPER.viewAuthenticatedUserCart(cartId);

            for (AuthenticatedUserCartItem item : items) {
                 Article article =ARTICLE_HELPER.getAricleById(item.getArticleId());
                 CartModel model = new CartModel();
                 model.setName(article.getName());
                 model.setAmount(item.getAmount());
                 model.setPrice(item.getPrice());
                 model.setTotalPrice(round(auc.getTotalPrice(),2));
                 model.setIdCartItem(item.getIdAuthenticatedCartItem());
                 
                 

                 list.add(model);
            }
            
             String list1 =new Gson().toJson(list);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(list1);
            out.flush();
        
        }
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int amount =Integer.valueOf(request.getParameter("amount"));
        if (amount <1) {
            amount = 0;
        }
        String userId1 = request.getParameter("userId");
        
        
        int userId;
        if (!userId1.equals("null")) {
            userId=Integer.valueOf(userId1);
        }
        else
        {
            userId=1;
        }
        
        double price = Double.valueOf(request.getParameter("price"));
        int articleID =Integer.valueOf(request.getParameter("articleID"));
        String category = request.getParameter("category");
        
        if (cartId == 0) {
            
            AuthenticatedUserCart cart = new AuthenticatedUserCart();
            cart.setAuthanticatedUserId(userId);
            cart.setAuthanticatedUserSessionId(1);
            cart.setPaymentOption("Delivery");
            cart.setPayed("NO");
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
            Integer cartId2 = cartId;
            String cartId2String = cartId2.toString();
            
            HttpSession cartSession=request.getSession(true);  
            cartSession.setAttribute("cartID",cartId2String);  
            
            if (category != null) {
             response.sendRedirect(category);
        }
            else
            {
            response.sendRedirect("allProducts.jsp");
            }

    }
    
    
  
      @Override
  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
     
        cartId =0;
            String id =new Gson().toJson(cartId);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(id);
            out.flush();
  }
    
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}

   
}
