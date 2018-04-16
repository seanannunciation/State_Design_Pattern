/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *This class is used to print the output
 * @author annse
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface{
       
    private String outputfile1;
    ArrayList<String> resultvalues=new ArrayList<String>();
    
    /**
     * This method writes the output to a file
     * @param s 
     */
    @Override
    public void writeToFile(String s) {
        
        Writer filewrite=null;
        try {
            filewrite=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile1),"utf-8"));
            for(int j=0;j<resultvalues.size();j++)
            {
                MyLogger.writeMessage("File Is Being Written", MyLogger.DebugLevel.FROM_RESULTS);
                filewrite.write(resultvalues.get(j)+"\n");
            }
            filewrite.flush();
            }
        catch(IOException e)
        {
            System.out.println("Error in writing to File");
        }
//        finally{
//            try(filewrite.close();)
//                catch(Exception e)
//                        {
//                        
//                        }
//        }
        
        
    }
    
    /**
     * This constructor assigns the output file to a private variable
     * @param file 
     */
    public Results(String file)
    {
        this.outputfile1=file;
        MyLogger.writeMessage("Inside Results Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    /**
     * This method is used to store the output in an arraylist
     * @param result 
     */
    public void storeNewResult(String result)
    {
        this.resultvalues.add(result);
        MyLogger.writeMessage("Storing In Result", MyLogger.DebugLevel.IN_RESULTS);
    }
    
    /**
     * This method is used to print the output
     * @param s 
     */
    @Override
    public void writeToStdout(String s){
        
        resultvalues.add(s);
        for(int i=0;i<resultvalues.size();i++)
        {
            System.out.println(resultvalues.get(i));
        }
        
        
    }
    
}
