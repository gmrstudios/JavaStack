package edu.wmich.cs1120.spring16.SMSPL.towerc.application;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;

import edu.wmich.cs1120.spring16.SMSPL.towerc.lists.ArrayList;
import edu.wmich.cs1120.spring16.SMSPL.towerc.lists.IList;
import edu.wmich.cs1120.spring16.SMSPL.towerc.stacks.Stack;

public class Application implements IApplication {
	
	
	/**
	 * @param - takes a string to be reversed; sent off to stack class
	 * @return - returns the reversed string as a String 
	 */
	@Override
	public String reverseString(String s) {
		// Create string builder object to use in reversing strings
		StringBuilder str = new StringBuilder(); 
		
		//Create a new stack object for pushing and popping as we reverse the string.
		Stack newStack = new Stack();
		
		// For loop to control pushing string values, one character
		// at a time, readying the values in stack class in order to
		// pop them off in reverse order, thus REVERSING the string.
		// See the nifty push statement using charAt()? :-)
		for(int i = 0; i < s.length(); i++)
		{
		newStack.push(String.valueOf(s.charAt(i)));
		}
		
		//For loop to peek at the value, which obtains it, and allows
		// us to append it to the string builder object and then
		// we call pop on the stack object, which in turn calls remove
		// which removes the character from the string we pushed in the
		// code above.
		for(int i = 0; i < s.length(); i++)
		{
			str.append(newStack.peek());
			newStack.pop();
		}
		// Return the reversed string built with string builder
		// but first we must use toString on it because it's an object.
		return str.toString();
	}

	@Override
	/**
	 * @return - Reads data from file into an object
	 * of type IList and returns the IList object.
	 */
	public IList readInputFile() {
		String line; // A number read from the file
	      boolean endOfFile = false;     // EOF flag
	      
	      IList listValues = new ArrayList();
	      
	      try{
	      // Create the binary file input objects.
	      FileInputStream fstream = new FileInputStream("input.bin");
	      DataInputStream inputFile = new DataInputStream(fstream);
	    
	      System.out.println("Reading data from the file:");

	      // Read the contents of the file.    
	      while (!endOfFile)
	      {
	         try
	         {    line = inputFile.readUTF();
	            //System.out.println(line);
	            String[] lines = line.split("\n");
	            for(String tokens: lines)
	            	listValues.add(tokens);
	         }
	         catch (EOFException e)
	         {
	            endOfFile = true;
	         }
	         catch (UTFDataFormatException e){
	        	 
	        	 System.out.println("Bytes do not represent a "
	        	 		+ "valid modified UTF-8 encoding.");
	         }
	      }

	      System.out.println("\nDone.");
	      
	      // Close the file.
	      inputFile.close();  
	      } // END BRACKT FOR try-catch file open-close
	      catch (IOException e)
	      {
	    	  System.out.println("Error in file input/output.");
	      }

		return listValues;
	}

	@Override
	public void writeOutputFile(IList output) {
		
		
	}

	
	
}
