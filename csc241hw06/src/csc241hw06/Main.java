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
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the input file name:");
        File f = new File(kb.nextLine());
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try{
            SAXParser sp = spf.newSAXParser();
            MyHandler handler = new MyHandler();
            sp.parse(f, handler);
            System.out.println("Enter the account number:");
            String number = kb.nextLine();
            ArrayList<Customer> cList = handler.getCustomers();
            boolean found = false;
            for(Customer c : cList){
                for(Account a : c.getAccounts()){
                    if(a.getAccountNumber().equals(number)){
                        a.updateBalance();
                        DecimalFormat df = new DecimalFormat("0.00");
                        String balance = df.format(a.getCurrentBalance());
                        System.out.println("Balance: $" + balance);
                        found = true;
                    }
                }
            }
            if(!found) System.out.println("Account number " + number + " not found.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
