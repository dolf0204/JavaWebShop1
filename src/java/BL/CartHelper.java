/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.List;
import model.AuthenticatedUser;
import model.AuthenticatedUserCart;

/**
 *
 * @author RudolfGumzej
 */
public class CartHelper extends HandlerBase{
    
    public int insertAuthenticatedUserCart(AuthenticatedUserCart cart) {
        return repository.insertAuthenticatedUserCart(cart);        
    }
    
     public AuthenticatedUserCart viewAuthenticatedUserCart(int id) {
        return repository.viewAuthenticatedUserCart(id);        
    }
  
      public List<AuthenticatedUserCart> viewAllAuthenticatedUserCart() {
        return repository.viewAllAuthenticatedUserCart();        
    }
      public List<AuthenticatedUserCart> getCartForAuthenticatedUser(int userID) {
        return repository.getCartForAuthenticatedUser(userID); 
        
    }
        public void updateAuthenticatedUserCart(AuthenticatedUserCart cart, int id)
    {
       repository.updateAuthenticatedUserCart(cart, id);

    }
         public  void deleteAuthenticatedUserCart(int id)
    {
      repository.deleteAuthenticatedUserCart(id);  
    }      
}
