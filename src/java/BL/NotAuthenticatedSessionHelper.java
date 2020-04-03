/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.List;
import model.AuthenticatedUserSession;
import model.NotAuthenticatedUserSession;

/**
 *
 * @author RudolfGumzej
 */
public class NotAuthenticatedSessionHelper extends HandlerBase{
    
    public void insertNotAuthenticatedUserSession(NotAuthenticatedUserSession session) {
        repository.insertNotAuthenticatedSession(session);        
    }
    
     public NotAuthenticatedUserSession getNotAuthenticatedUserSession(int userId) {
        return repository.getNotAuthenticatedSession(userId);        
    }
     
       public List<NotAuthenticatedUserSession> getAllNotAuthenticatedUserSessions() {
        return repository.getAllNotAuthenticatedSessions();        
    }
}
