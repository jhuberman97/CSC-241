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
public class Commercial extends Address{
    
    public Commercial(int n, String s, String z){
        super(n, s, z);
    }
    
    public String getType(){
        return "commercial";
    }
}