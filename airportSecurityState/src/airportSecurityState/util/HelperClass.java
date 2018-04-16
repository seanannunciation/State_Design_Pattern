/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import airportSecurityState.airportStates.HighRisk;
import airportSecurityState.airportStates.LowRisk;
import airportSecurityState.airportStates.ModRisk;
import airportSecurityState.airportStates.AirportContextState;

/**
 *This class is used to perform various calculations and input file processing
 * @author annse
 */
public class HelperClass {
    
    AirportContextState apstate=new AirportContextState();
    
            int dcount=1;
            int icount=0;
            int tcount=0;
    
            
    /**
     * This is a constructor of HelperClass which sets the value of the context class variable
     * @param ast 
     */        
    public HelperClass(AirportContextState ast){
        apstate=ast;
    }
    
    /**
     * This method is used to split the input line depending on various delimiters
     * @param line 
     */
    
    public void split(String line) {
   
            String temp[]=line.split(";");
            String dayno=temp[0];
            String itemval=temp[3];
            String dayvalues[]=dayno.split(":");
            String itemvalues[]=itemval.split(":");
            int dayno1=Integer.parseInt(dayvalues[1]);
            
            String itemno = itemvalues[1];
            
            
             tcount++;
             if(dayno1>dcount)
                 {
                     dcount++; 
                 }
              
              if(itemno.equals("Gun"))
                  icount++;
              else if(itemno.equals("NailCutter"))
                 icount++;
              else if(itemno.equals("Blade"))
                 icount++;
              else if(itemno.equals("Knife"))
                 icount++;
              
              
              apstate.settravellers(tcount);
              apstate.setprohibiteditems(icount);
              apstate.setdays(dcount);
    
       
        }
    
    
    /**
     * This method computes the avgTrafficPerDay
     * @return 
     */
    
    
            public int avgTrafficPerDay(){
                
                int trav=apstate.gettravellers();
		int days=apstate.getdays();
		int items=apstate.getitems();
                
                int avg_traffic_per_day=trav/days;
                
                return avg_traffic_per_day;
            }
            
            /**
             * This method calculates the avgProhibitedItemsPerDay 
             * @return 
             */
            public int avgProhibitedItemsPerDay(){
                
                int trav=apstate.gettravellers();
		int days=apstate.getdays();
		int items=apstate.getitems();
                
                int avg_prohibited_items_per_day=items/days;
                
                return avg_prohibited_items_per_day;
            }
    }
    

