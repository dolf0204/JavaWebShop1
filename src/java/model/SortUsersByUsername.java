/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author RudolfGumzej
 */
public class SortUsersByUsername implements Comparator<AdminShoppingHistoryModel>{
    
     @Override
    public int compare(AdminShoppingHistoryModel o1, AdminShoppingHistoryModel o2) {
        return o1.getUsername().compareTo(o2.getUsername());
    }
    
}
