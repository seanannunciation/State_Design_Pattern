/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import airportSecurityState.airportStates.HighRisk;
import airportSecurityState.airportStates.LowRisk;
import airportSecurityState.airportStates.ModRisk;
import airportSecurityState.airportStates.AirportContextState;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.HelperClass;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

/**
 * The Driver is the main class where the input file,output file and debug values are read and processing is later done
 * @author annse
 */
public class Driver {

	public static void main(String args[]) throws FileNotFoundException, IOException{
            
            AirportContextState apstate=new AirportContextState();
            //String filename1="D:\\Courses\\Design Patterns\\input.txt";
            String filename1="";
          //  FileReader fr=new FileReader(filename1);
            //String outputfile1="D:\\Courses\\Design Patterns\\output.txt";
            String outputfile1="";
            int debugval=0;
            int arglength=args.length;
            //MyLogger.setDebugValue(3);
            
        
        if (arglength!=3){
            System.out.println("Please enter only 3 arguments");
        }
        else{
            filename1=args[0];
            outputfile1=args[1];
            if (Integer.parseInt(args[2])>4&&Integer.parseInt(args[2])<0)
            {
                System.out.println("The Debug Values should be in the range of 0-4");
                
            }
            else
            {
                debugval=Integer.parseInt(args[2]);
                MyLogger.setDebugValue(debugval);
            }
            
            
        }

	FileReader fr=new FileReader(filename1);
            FileProcessor fp1=new FileProcessor(filename1);
            Results r=new Results(outputfile1);
            HelperClass hp=new HelperClass(apstate);
            apstate.setResult(r);
            BufferedReader br =new BufferedReader(fr);
            
        
            
    String inputLine = null;
    while((inputLine=fp1.readLine())!=null)
    {
         String temp=inputLine;
              hp.split(temp);
                
                if(apstate.getcurrentstate() instanceof LowRisk ){
                    apstate.getcurrentstate().tightenOrLoosenSecurity(hp);
                }
                
                else if(apstate.getcurrentstate() instanceof ModRisk ){
                    apstate.getcurrentstate().tightenOrLoosenSecurity(hp);
                } 
                
                else if(apstate.getcurrentstate() instanceof HighRisk ){
                    apstate.getcurrentstate().tightenOrLoosenSecurity(hp);
                }
                   
                }
        //}
//        if(inputLine==null)
//        System.out.println("ENDOFFILE");
//         
       r.writeToFile("");
       
       }
        }
           
	
    

