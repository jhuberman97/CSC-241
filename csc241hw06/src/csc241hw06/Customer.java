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
public class Customer {
    
    private String lastName;
    private String firstName;
    private Address address;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    
    public Customer(String l, String f, Address a){
        lastName = l;
        firstName = f;
        address = a;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public Address getMailingAddress(){
        return address;
    }
    
    public Account[] getAccounts(){
        Account[] array = new Account[accounts.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = accounts.get(i);
        }        
        return array;
    }
    
    public boolean addAccount(Account a){
        return accounts.add(a);
    }
    
    public boolean removeAccount(Account a){
        return accounts.remove(a);
    }
}
