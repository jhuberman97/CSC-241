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
public class ResidentialAccount extends Account{
    
    public ResidentialAccount(String a, Customer c){
        super(a, c);
    }
    
    public void updateBalance(){
        double sum = 0;
        for (int i = 0; i < this.getAddresses().length; i++) {
            if(this.getAddresses()[i] instanceof Residence 
                    || this.getAddresses()[i] instanceof Apartment){}
            else continue;
            for (int j = 0; j < this.getAddresses()[i].getMeters().length; j++) {
                for (int k = 0; k < this.getAddresses()[i].getMeters()[j].getReadings().length; k++) {
                    sum += this.getAddresses()[i].getMeters()[j].getReadings()[k].getReading();
                }
            }
        }
        this.setBalance(sum * residentialUnitRate);
    }
    
    public boolean addAddress(Address a){
        if(a instanceof Residence || a instanceof Apartment){
            return updateAddresses(a);
        }
        else return false;
    }
}
