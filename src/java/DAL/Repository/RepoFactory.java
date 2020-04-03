/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Repository;

/**
 *
 * @author RudolfGumzej
 */
public final class RepoFactory {
    public static IRepo getRepository() {
        return new SqlRepo();
    }
}
