/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repository;

import java.util.List;
import model.Article;
import model.AuthenticatedUser;
import model.AuthenticatedUserCart;
import model.AuthenticatedUserCartItem;
import model.AuthenticatedUserSession;
import model.NotAuthenticatedUserSession;

/**
 *
 * @author RudolfGumzej
 */
public interface IRepo {
    int insertUser(AuthenticatedUser user);
    AuthenticatedUser getUser(int id);
    AuthenticatedUser getUserByUsername(String username);
    AuthenticatedUser logInUser(String username, String password);
    List<AuthenticatedUser> getAllUsers();
    void updateUser(AuthenticatedUser user, int idUser);
    void deleteUser(int idUser);
    
     void insertAuthenticatedSession(AuthenticatedUserSession session);
    List<AuthenticatedUserSession> getAuthenticatedSession(int userId);
     List<AuthenticatedUserSession> getAllAuthenticatedSessions();
     
      void insertNotAuthenticatedSession(NotAuthenticatedUserSession session);
     NotAuthenticatedUserSession getNotAuthenticatedSession(int userId);
     List<NotAuthenticatedUserSession> getAllNotAuthenticatedSessions();
     
     Article getArticle(String name);
     Article getArticleById(int id);
     List<Article> getAllArticles();
     
     int insertauthenticatedUserCartItem(AuthenticatedUserCartItem item);
     void updateAuthenticatedUserCartItem(AuthenticatedUserCartItem item,int idAuthenticatedUserCartItem);
     void deleteAuthenticatedCartItem(int idAuthenticatedUserCartItem);
     List<AuthenticatedUserCartItem> viewCartItemsForCart(int authenticatedUserCartId);
     List<AuthenticatedUserCartItem> viewAllAuthenticatedUserCartItems();
     AuthenticatedUserCartItem viewAuthenticatedCartItem(int id);
     
     
     int insertAuthenticatedUserCart(AuthenticatedUserCart cart);
     void updateAuthenticatedUserCart(AuthenticatedUserCart cart,int idAuthenticatedUserCart);
     void deleteAuthenticatedUserCart(int idAuthenticatedUserCart);
     AuthenticatedUserCart viewAuthenticatedUserCart(int idAuthenticatedUserCart);
     List<AuthenticatedUserCart> viewAllAuthenticatedUserCart();
     List<AuthenticatedUserCart> getCartForAuthenticatedUser(int userID);
     
     
     
     
}
