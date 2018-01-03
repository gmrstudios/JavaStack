package edu.wmich.cs1120.spring16.SMSPL.towerc.application;

import edu.wmich.cs1120.spring16.SMSPL.towerc.lists.ArrayList;
import edu.wmich.cs1120.spring16.SMSPL.towerc.lists.IList;

/*
 * NAME: Oliver Sanchex & Chris Tower
 * DATE OF ASSIGMENT SUBMISSION: April, 06 2016
 * COURSE DATA: CS1120-543-LA6
 * 
 * PROGRAM DESCRIPTION: REVERSE STRING PROGRAM USING STACK
 * 
 *  
 */

public class Main {
	
public static void main(String[] args) {

	Application app = new Application();
	IList inputStrings = app.readInputFile();
	IList reversedStrings = new ArrayList();
	inputStrings.add(2,"String added to index 2");
	
	for(int i=0; i<inputStrings.size();i++){
			reversedStrings.add(app.reverseString(inputStrings.get(i)));
			app.printToScreen(inputStrings.get(i),
					reversedStrings.get(i));
			} // END BRACKET for reverse string for loop
	
		app.writeOutputFile(reversedStrings);
		
	} // END BRACKET for MAIN class
} // END BRACKET for public class MAIN
