/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.airportStates;

import airportSecurityState.util.HelperClass;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

/**
 *This is the context class used to set the parameters
 * @author annse
 */ 
    
public class AirportContextState {
	
	private airportStateI low_risk;
	private airportStateI moderate_risk;
	private airportStateI high_risk;
	
	private int total_no_of_travellers;
	private int total_no_of_days;
	private int total_no_of_prohibited_items;
	
	private airportStateI current_state;
        
        private Results r2;
        
        HelperClass hp;
	
        /**
         * This method sets the value of the result
         * @param r 
         */
        public void setResult(Results r)
        {
            r2=r;
        }
        /**
         * This method is used to get the result object which has been set
         * @return 
         */
        public Results getResult(){
            return r2;
        }
	
        /**
         * This method sets the travellers parameter to the variable
         * @param travellers 
         */
        public void settravellers(int travellers){
            total_no_of_travellers=travellers;
        }
        
        /**
         * This method sets the days parameters 
         * @param days 
         */
        public void setdays(int days){
            total_no_of_days=days;
        }
        
        /**
         * This method sets the items parameter
         * @param items 
         */
        public void setprohibiteditems(int items){
            total_no_of_prohibited_items=items;
        }
      
	/**
         * This method returns the total_no_of_travellers
         * @return 
         */
	public int gettravellers(){
		return total_no_of_travellers;
	}
	
        /**
         * This method returns total_no_of_days
         * @return 
         */
	public int getdays(){
		return total_no_of_days;
	}
	
        /**
         * This method returns total_no_of_prohibited_items
         * @return 
         */
	public int getitems(){
		return total_no_of_prohibited_items;
	}
	
        /**
         * This constructor sets the state variables
         */
	public AirportContextState(){
		low_risk=new LowRisk(this);
		moderate_risk=new ModRisk(this);
		high_risk=new HighRisk(this);
		
		current_state=low_risk;
                
                MyLogger.writeMessage("Inside airportState Constructor", MyLogger.DebugLevel.CONSTRUCTOR);

		
	}
        
        /**
         * This method is used to obtain the current state
         * @return 
         */
        public airportStateI getcurrentstate(){
            return current_state;
        }
	
        /**
         * This method is used to set the current state
         * @param arpstate 
         */
	void setairportstate(airportStateI arpstate)
	{
		current_state=arpstate;
	}
	
        /**
         * This method is used to determine the list of operations to be performed
         */
	public void tightenOrLoosenSecurity(){
		current_state.tightenOrLoosenSecurity(hp);
	}
	
        
        /**
         * This method returns the lowrisk object
         * @return 
         */
	public airportStateI getlowrisk()
	{
		return low_risk;
	}
	
        /**
         * This method returns the modrisk object
         * @return 
         */
	public airportStateI getmoderaterisk()
	{
		return moderate_risk;
	}
	
        /**
         * This method returns the highrisk object
         * @return 
         */
	public airportStateI gethighrisk()
	{
		return high_risk;
	}

}
    

