/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.List;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;

/**
 *
 * @author RudolfGumzej
 */
public class CartItemHelper extends HandlerBase{
    
    public int insertAuthenticatedUserCartItem(AuthenticatedUserCartItem item) {
        return repository.insertauthenticatedUserCartItem(item);        
    }
    
     public List<AuthenticatedUserCartItem> viewCartItemsForCart(int idCart) {
        return repository.viewCartItemsForCart(idCart);        
    }
  
     public List<AuthenticatedUserCartItem> viewAllAuthenticatedUserCartItems() {
        return repository.viewAllAuthenticatedUserCartItems();        
    }
  
     public AuthenticatedUserCartItem viewAuthenticatedCartItem(int id) {
        return repository.viewAuthenticatedCartItem(id);        
    }
     public void updateAuthenticatedUserCartItem(AuthenticatedUserCartItem item, int id)
    {
       repository.updateAuthenticatedUserCartItem(item, id);

    }
     public  void deleteAuthenticatedCartItem(int id)
    {
      repository.deleteAuthenticatedCartItem(id);  
    }      
}
