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
public class SortLogInByDate implements Comparator<LogInHistoryModel> {

    @Override
    public int compare(LogInHistoryModel o1, LogInHistoryModel o2) {
           return o1.getLogInDate().compareTo(o2.getLogInDate());
    }
    
}
