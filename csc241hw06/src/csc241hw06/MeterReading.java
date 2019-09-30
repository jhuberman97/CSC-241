/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author jehub
 */
public class MeterReading {
    
    private double reading;
    private LocalDateTime dateTime;
    private String flag;
    private Meter meter;
    
    public MeterReading(double r, LocalDateTime d, String f, Meter m){
        reading = r;
        dateTime = d;
        flag = f;
        meter = m;
    }
    
    public double getReading(){
        return reading;
    }
    
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    
    public String getFlag(){
        return flag;
    }
    
    public Meter getMeter(){
        return meter;
    }
}
