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
public class PushMeter extends Meter{
    
    private int interval;
    
    public PushMeter(String i, String b){
        super(i, b);
    }
    
    public String getType(){
        return "push";
    }
    
    public void setInterval(int s){
        interval = s;
    }
    
    public int getInterval(){
        return interval;
    }
}
