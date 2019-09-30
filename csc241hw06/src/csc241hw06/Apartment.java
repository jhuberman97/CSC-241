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
public class Apartment extends Address{
    
    private String unit;
    
    public Apartment(int n, String s, String z, String u){
        super(n, s, z);
        unit = u;
    }
    
    public void setUnit(String u){
        unit = u;
    }
    
    public String getUnit(){
        return unit;
    }
    
    public String getType(){
        return "apartment";
    }
}
