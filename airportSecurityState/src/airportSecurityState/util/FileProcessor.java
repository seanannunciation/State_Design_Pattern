/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *This class is used to read the input file and process it 
 * @author annse
 */
public class FileProcessor {
    
       
    public int count=0;
    public ArrayList<String> list;
    String line;
    public String iline;
    FileReader fr;
    BufferedReader br;
    String fileName;
    
    /**
     * This is a constructor of FileProcessor which sets the filename to a local variable
     * @param Filename 
     */
    
    public FileProcessor(String Filename)
    {
        list=new ArrayList<String>();
        fileName = Filename;
        MyLogger.writeMessage("Inside FileProcessor Constructor", MyLogger.DebugLevel.CONSTRUCTOR);

//        try
//        {
//        fr = new FileReader(Filename);
//        br =new BufferedReader(fr);
//         while ((line=br.readLine())!=null)
//		{
//                    iline=line;
//                    //System.out.println("----"+iline);
//                    list.add(line);
//		} 
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
    }
    
    
    FileReader fileReader = null;
    BufferedReader buffReader = null;
    String inputLine = null;
    
    /**
     * This method is used to return the line read from the file to the driver
     * @return 
     */
    public String readLine() 
    {
        
        try
        {
            if(fileReader==null){
        fileReader = new FileReader(fileName);
            }
            if(buffReader == null){
        buffReader =new BufferedReader(fileReader);
            }
         while ((inputLine=buffReader.readLine())!=null)
		{
                    //System.out.println(inputLine);
                    return inputLine;
		} 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
//        String lineread=null;
//        try
//        {
//	lineread=list.get(count);
//        
//        count++;
//        //return lineread;
//
//	}
//        catch(Exception e)
//    {
//        e.printStackTrace();
//    }
//        //return "";
//        return lineread;
    }
    
}
    
