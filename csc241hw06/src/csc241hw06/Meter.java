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
import java.util.ArrayList;
public abstract class Meter {
    
    private String id;
    private String brand;
    private String location;
    private Address address;
    private ArrayList<MeterReading> readings = new ArrayList<MeterReading>();
    
    public Meter(String i, String b){
        id = i;
        brand = b;
    }
    
    public String getID(){
        return id;
    }
    
    public MeterReading[] getReadings(){
        MeterReading[] array = new MeterReading[readings.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = readings.get(i);
        }
        return array;
    }
    
    public MeterReading getCurrentReading(){
        if(readings.size() == 0) return null;
        else return readings.get(readings.size() - 1);
    }
    
    public boolean addReading(MeterReading m){
        return readings.add(m);
    }
    
    public String getBrand(){
        return brand;
    }
    
    public abstract String getType();
    
    public String getLocation(){
        return location;
    }
    
    public Address getAddress(){
        return address;
    }
    
    public void setLocation(Address a, String n){
        address = a;
        location = n;
    }
}
