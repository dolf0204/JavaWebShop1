/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.List;
import model.AuthenticatedUser;
import model.AuthenticatedUserSession;

/**
 *
 * @author RudolfGumzej
 */
public class AuthenticatedSessionHelper extends HandlerBase{
    
    public void insertAuthenticatedUserSession(AuthenticatedUserSession session) {
        repository.insertAuthenticatedSession(session);        
    }
    
     public List<AuthenticatedUserSession> getAuthenticatedUserSession(int userId) {
        return repository.getAuthenticatedSession(userId);        
    }
     
       public List<AuthenticatedUserSession> getAllAuthenticatedUserSessions() {
        return repository.getAllAuthenticatedSessions();        
    }
}
