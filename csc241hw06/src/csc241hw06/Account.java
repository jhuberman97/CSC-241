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
public abstract class Account implements Pricing{
    
    private String accountNumber;
    private Customer customer;
    private double balance;
    private ArrayList<Address> addresses = new ArrayList<Address>();
    
    public Account(String a, Customer c){
        accountNumber = a;
        customer = c;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public double getCurrentBalance(){
        return balance;
    }
    
    public void setBalance(double b){
        balance = b;
    }
    
    public Address[] getAddresses(){
        Address[] array = new Address[addresses.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = addresses.get(i);
        }        
        return array;
    }
    
    public boolean removeAddress(Address a){
        return addresses.remove(a);
    }
    
    public boolean updateAddresses(Address a){
        return addresses.add(a);
    }
    
    public abstract boolean addAddress(Address a);
}
