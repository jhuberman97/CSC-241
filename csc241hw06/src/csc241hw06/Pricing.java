/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

/**
 *
 * @author jehub
 */
public interface Pricing {
    double residentialUnitRate = 0.14;
    double commercialUnitRate = 0.125;
    
    public void updateBalance();
}
