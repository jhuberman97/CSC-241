/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 *
 * @author jehub
 */
public class MyHandler extends DefaultHandler{
    Customer currentCustomer;
    Account currentAccount;
    Address currentAddress;
    Meter currentMeter;
    MeterReading currentReading;
    String currentFName;
    String currentLName;
    
    ArrayList<Customer> customers = new ArrayList<>();
    
    boolean handlingMailing;
    
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException{
        if(qName.equals("customer")){
            currentLName = attributes.getValue("lastName");
            currentFName = attributes.getValue("firstName");
        }
        else if(qName.equals("address") && 
                attributes.getValue("type").equals("mailing")){
            handlingMailing = true;
            Address mailing = new Mailing(Integer.parseInt(attributes.getValue("number")), 
                    attributes.getValue("street"), attributes.getValue("zipCode"));
            currentCustomer = new Customer(currentLName, currentFName, mailing);
        }
        else if(qName.equals("account")){
            if(attributes.getValue("type").equals("residential")){
                currentAccount = new ResidentialAccount(attributes.getValue("accountNumber"),
                        currentCustomer);
            }
            else if(attributes.getValue("type").equals("commercial")){
                currentAccount = new CommercialAccount(attributes.getValue("accountNumber"),
                        currentCustomer);
            }
        }
        else if(qName.equals("address") &&
                !(attributes.getValue("type").equals("mailing"))){
            handlingMailing = false;
            if(attributes.getValue("type").equals("apartment")){
                currentAddress = new Apartment(Integer.parseInt(attributes.getValue("number")),
                        attributes.getValue("street"), attributes.getValue("zipCode"),
                        attributes.getValue("unit"));
            }
            else if(attributes.getValue("type").equals("commercial")){
                currentAddress = new Commercial(Integer.parseInt(attributes.getValue("number")),
                        attributes.getValue("street"), attributes.getValue("zipCode"));
            }
            else if(attributes.getValue("type").equals("residence")){
                currentAddress = new Residence(Integer.parseInt(attributes.getValue("number")),
                        attributes.getValue("street"), attributes.getValue("zipCode"));
            }
        }
        else if(qName.equals("meter")){
            if(attributes.getValue("type").equals("push")){
                currentMeter = new PushMeter(attributes.getValue("id"), 
                        attributes.getValue("brand"));
            }
            else if(attributes.getValue("type").equals("poll")){
                currentMeter = new PollMeter(attributes.getValue("id"),
                        attributes.getValue("brand"));
            }
        }
        else if(qName.equals("meterReading")){
            currentReading = new MeterReading(Double.parseDouble(attributes.getValue("reading")),
                    LocalDateTime.parse(attributes.getValue("date")),
                    attributes.getValue("flag"), currentMeter);
        }
    }
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equals("meterReading")){
            currentMeter.addReading(currentReading);
        }
        else if(qName.equals("meter")){
            currentAddress.addMeter(currentMeter);
        }
        else if(qName.equals("address") && !handlingMailing){
            currentAccount.addAddress(currentAddress);
        }
        else if(qName.equals("account")){
            currentCustomer.addAccount(currentAccount);
        }
        else if(qName.equals("customer")){
            customers.add(currentCustomer);
        }
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
}
