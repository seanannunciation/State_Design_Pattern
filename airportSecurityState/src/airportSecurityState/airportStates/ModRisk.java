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
 *This Class is used to define the ModRisk state
 * @author annse
 */
public class ModRisk implements airportStateI {

	AirportContextState astate;
	Results r;
        //HelperClass hc=new HelperClass(astate);
        HelperClass hc;
        
        
        /**
         * This constructor sets the values of the parameters
         * @param asI 
         */
        
	public ModRisk(AirportContextState asI){
		astate=asI;
                r=astate.getResult();
                MyLogger.writeMessage("Inside ModRisk Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
                
        }
        
        
        /**
         * This method is used to determine the state and print the output
         * @param helpc 
         */
	@Override
	public void tightenOrLoosenSecurity(HelperClass helpc) {
		// TODO Auto-generated method stub

		hc=helpc;
                
                int avg_traffic_per_day=hc.avgTrafficPerDay();
		int avg_prohibited_items_per_day=hc.avgProhibitedItemsPerDay();
                
                if((avg_traffic_per_day>=8)||(avg_prohibited_items_per_day>=2))
                {
                    MyLogger.writeMessage("2 4 6 8 10", MyLogger.DebugLevel.IN_RUN);
                    r.storeNewResult("2 4 6 8 10");
                    astate.gethighrisk();
                    
                }
                
                else if((avg_traffic_per_day>=4)&&(avg_traffic_per_day<8)||
                        (avg_prohibited_items_per_day>=1)&&(avg_prohibited_items_per_day<2))
                {
                    MyLogger.writeMessage("2 3 5 8 9", MyLogger.DebugLevel.IN_RUN);
                    r.storeNewResult("2 3 5 8 9");
                    astate.getmoderaterisk();
                }
                
                else if((avg_traffic_per_day>=0)&&(avg_traffic_per_day<4)||
                        (avg_prohibited_items_per_day>=0)&&(avg_prohibited_items_per_day<1))
                {
                    MyLogger.writeMessage("1 3 5 7 9", MyLogger.DebugLevel.IN_RUN);
                    r.storeNewResult("1 3 5 7 9");
                    astate.getlowrisk();
                }
                                   
                
                

	}

}
    

