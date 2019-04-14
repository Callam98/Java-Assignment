package com.Assignment.OOP;

import java.io.FileNotFoundException;
/***********************
 * 
 * Author:Callam Leakey
 * Date:14/4/19
 * Assignment: Naive Baise Assignment to be test data and output a result
 * assigment must also be able to adapt and read new data entered
 */

public class Control {

	public static void main(String[] args) throws FileNotFoundException 
	{
		FileProcessor F1 = new FileProcessor();
		//Opens Login Page
		Login L1 = new Login("Login");
		
	
		//Sets L1's Size and sets visible
		L1.setVisible(true);
		L1.setSize(300,200);

	}

}
