/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.List;
import model.AuthenticatedUser;

/**
 *
 * @author RudolfGumzej
 */
public class UserHelper extends HandlerBase{
    
    public int insertUser(AuthenticatedUser user) {
        return repository.insertUser(user);        
    }
    
     public AuthenticatedUser getUser(int id) {
        return repository.getUser(id);        
    }
     public AuthenticatedUser getUserByUsername(String username) {
        return repository.getUserByUsername(username);        
    }
      public AuthenticatedUser logInUser(String username,String password) {
        return repository.logInUser(username,password);        
    }
      
      public List<AuthenticatedUser> getAllUsers() {
        return repository.getAllUsers();        
    }
        public void updateUser(AuthenticatedUser user, int idUser)
    {
       repository.updateUser(user, idUser);

    }
         public  void deleteUser(int idUser)
    {
      repository.deleteUser(idUser);  
    }      
}
