/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.util.ArrayList;

/**
 *
 * @author jehub
 */
public abstract class Address {
    
    private int number;
    private String street;
    private String zipCode;
    private ArrayList<Meter> meters = new ArrayList<Meter>();
    
    public Address(int n, String s, String z){
        number = n;
        street = s;
        zipCode = z;
    }
    
    public int getNumber(){
        return number;
    }
    
    public String getStreet(){
        return street;
    }
    
    public String getZipCode(){
        return zipCode;
    }
    
    public abstract String getType();
    
    public Meter[] getMeters(){
        Meter[] array = new Meter[meters.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = meters.get(i);
        }        
        return array;
    }
    
    public boolean addMeter(Meter m){
        return meters.add(m);
    }
    
    public boolean removeMeter(String id){
        for(int i = 0; i < meters.size(); i++){
            if(id.equals(meters.get(i).getID())){
                meters.remove(i);
                return true;
            }
        }
        return false;
    }
}
