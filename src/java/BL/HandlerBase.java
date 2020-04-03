/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAL.Repository.IRepo;
import DAL.Repository.RepoFactory;

/**
 *
 * @author RudolfGumzej
 */
public abstract class HandlerBase {
     public final IRepo repository;
    public HandlerBase() {
        repository = RepoFactory.getRepository();
    }
}
