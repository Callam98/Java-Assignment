package com.Assignment.OOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileProcessor
{
	//Counters 
	
	private int LCount = 0;
	private int Columns;
	//Arrays 
	private String[] LineContent;  
	private String[][] FileContent;  
	private String[][]TrainingData;	
	//File Attributes
	private File Data;
	//ProbabliltyArrays
	private double[] yesProbs;
	private double[] noProbs;
	//Value Counters
	private double valueYesCounter = 0; 
	private double valueNoCounter  = 0;
	private int ArrayCounter   = 0;
	//Counters For Finding Tonsilitis
	private double yesTons = 0;
	private double noTons  = 0;
	
	//File Scanner and writer used for reading and writing to files 
	private Scanner S1;
	private FileWriter W1;
	//Value of final Probability
	private double probTons;
	private double pronNotTons;

	
	public FileProcessor() 
	{
		Data = new File("src\\com\\Assignment\\OOP\\TrainData.csv");
		
		try 
		{
			//Reads in Data File
			S1 = new Scanner(Data);
			while (S1.hasNextLine()) 
			{
				String line = S1.nextLine();
				LineContent = line.split(",");																
				LCount++;
			}
			
			Columns = LineContent.length;

		
			S1 = new Scanner(Data);
			FileContent = new String[LCount][Columns];
			TrainingData = new String[ (int)(LCount* 0.7)][Columns];// train data will be 70% of the overall data set
			yesProbs = new double[Columns];
			noProbs = new double[Columns];
			LCount = 0;
			//Copies the contenets of the file into an array and then displays it
			while (S1.hasNextLine())
			{
				String line = S1.nextLine();
				LineContent = line.split(",");
				for (int i = 0; i < Columns; i++)
				{
					FileContent[LCount][i] = LineContent[i];

					if (i == 4 && LineContent[i].equals("yes")) 
					{
						yesTons++;
					}
				}

				LCount++;
			}

			noTons =  LCount - yesTons;
			
			S1.close();

		} 
		catch (IOException e) 
		{
			System.out.println("\nFile Not Found");

		} 
		for (int i = 0; i < LCount; i++) 
		{
			System.out.print("\n__________________________\n");

			for (int j = 0; j < Columns; j++)
			{
				System.out.print(FileContent[i][j]+" | ");
			}
		}
	}
	public double multiply(double[] list) 
	{
		double total = list[0];
		
		for (int i = 0; i < 3; i++)
		{
			total = total * list[i+1] ;
		}
		
		return total;
	}
	public double probsCalc(String temp, String aches, String throat)
	{
		ArrayCounter =0;
	
		countCol("temp",temp,aches,throat,FileContent,LCount,yesTons,noTons);
		countCol("aches",temp,aches,throat,FileContent,LCount,yesTons,noTons);
		countCol("throat",temp,aches,throat,FileContent,LCount,yesTons,noTons);

		// Multiplies the array of probabilities
		
		probTons   = multiply(yesProbs);
		pronNotTons = multiply(noProbs);
	
		probTons = probTons/(probTons+pronNotTons);
		
		System.out.println(probTons*100+" % Chance of Tonsilitis");
		
		return probTons;
	}
	public String calcProbability(String temp, String aches, String throat,String[][] trainData,int lines,double yesCount,double noCount)
	{
		ArrayCounter =0;
		countCol("temp",temp,aches,throat,trainData,lines,yesCount,noCount);
		countCol("aches",temp,aches,throat,trainData,lines,yesCount,noCount);
		countCol("throat",temp,aches,throat,trainData,lines,yesCount,noCount);
		probTons   = multiply(yesProbs);
		pronNotTons = multiply(noProbs);
		if(probTons > pronNotTons)
		{
			return "yes";
		}
		else 
		{
			return "no";
		}
		
	}
	public void countCol(String colName, String temp, String aches, String throat,String[][] trainData,int lineCount,double tonYes,double tonNo) 
	{
		if(colName.equals("temp"))
		{
			for (int i = 0; i < lineCount; i++)
			{
				if (trainData[i][1].equals(temp) && trainData[i][4].equals("yes")) 
				{
					valueYesCounter++;
				}
			}
			for (int i = 0; i < lineCount; i++)
			{
				if (trainData[i][1].equals(temp) && trainData[i][4].equals("no"))
				{
					valueNoCounter++;
				}
			}
			yesProbs[ArrayCounter] = ( (valueYesCounter / tonYes));
			noProbs[ArrayCounter]  = ( (valueNoCounter / tonNo));
			
			ArrayCounter++;
			valueYesCounter = 0;
			valueNoCounter  = 0;
			
		}
		else if(colName.equals("aches"))
		{
			// Count probability of the value aches and yes
			for (int i = 0; i < lineCount; i++)
			{
				if (trainData[i][2].equals(aches) && trainData[i][4].equals("yes")) 
				{
					valueYesCounter++;
					
				}
			}
			
			// Count probability of the value aches and no
			for (int i = 0; i < lineCount; i++) 
			{
				if (trainData[i][2].equals(aches) && trainData[i][4].equals("no")) 
				{
					valueNoCounter++;
				}
			}
			
			//Add probabilities to array
			yesProbs[ArrayCounter] =((valueYesCounter / tonYes));
			noProbs[ArrayCounter]  = ( (valueNoCounter / tonNo));
			
			ArrayCounter++;
			valueYesCounter = 0;
			valueNoCounter  = 0;
		}
		else if(colName.equals("throat"))
		{
			for (int i = 0; i < lineCount; i++) 
			{
				if (trainData[i][3].equals(throat) && trainData[i][4].equals("yes"))
				{
					valueYesCounter++;
				}

			}
			for (int i = 0; i < lineCount; i++)
			{
				if (trainData[i][3].equals(throat) && trainData[i][4].equals("no"))
				{
					valueNoCounter++;
					
				}

			}
			
			//Add probabilities to array
			yesProbs[ArrayCounter] =( (valueYesCounter / tonYes));
			noProbs[ArrayCounter] = ( (valueNoCounter / tonNo));
			
			ArrayCounter++;
			valueYesCounter = 0;
			valueNoCounter = 0;
		}
		
		yesProbs[ArrayCounter] =( tonYes / lineCount);
		noProbs[ArrayCounter] =( tonNo / lineCount);
	}
	
	private void T_Data()
	{
		for (int i = 0; i < (int)(LCount*0.7); i++) 
		{
			
			for (int j = 0; j < Columns; j++)
			{
				TrainingData[i][j] = FileContent[i][j];

			}

		}
		
		
	}
public double accuracy()
	{
		double testNum =0;
		double success = 0;
		double yesCount = 0;
		double noCount = 0;
		T_Data();
		//Counts Yes 
		for (int i = 0; i < (int)(LCount*0.7); i++) 
		{
			
			if(TrainingData[i][4].equals("yes")) 
			{
				yesCount++;
			}
			

		}
		noCount = ((int)(LCount*0.7)) - yesCount;
		for(int i = (int)(LCount*0.7);i<LCount;i++)
		{
			if(FileContent[i][4].equals(calcProbability(FileContent[i][1],FileContent[i][2],FileContent[i][3],TrainingData,(int)(LCount*0.7),yesCount,noCount)))
			{
				 success++;
			}
			testNum++;
		}
		System.out.println("\nCorrect :"+ success+"\nTotal :"+ testNum);
		return ((success/testNum) * 100);		

	}

//////Getters & Setters
public int getLineCount() {
	return LCount;
}

public void setLineCount(int lineCount) {
	this.LCount = lineCount;
}

public int getCols() {
	return Columns;
}

public void setCols(int cols) {
	this.Columns = cols;
}

public double getValueYesCounter() {
	return valueYesCounter;
}

public void setValueYesCounter(double valueYesCounter) {
	this.valueYesCounter = valueYesCounter;
}

public double getValueNoCounter() {
	return valueNoCounter;
}

public void setValueNoCounter(double valueNoCounter) {
	this.valueNoCounter = valueNoCounter;
}

public int getProbArrayCounter() {
	return ArrayCounter;
}

public void setProbArrayCounter(int probArrayCounter) {
	this.ArrayCounter = probArrayCounter;
}

public File getPatientData() {
	return Data;
}

public void setPatientData(File patientData) {
	this.Data = patientData;
}
public Scanner getFileScanner() {
	return S1;
}

public void setFileScanner(Scanner fileScanner) {
	this.S1 = fileScanner;
}

public FileWriter getFr() {
	return W1;
}

public void setFr(FileWriter fr) {
	this.W1 = fr;
}

public String[] getLineValues() {
	return LineContent;
}

public void setLineValues(String[] lineValues) {
	this.LineContent = lineValues;
}

public String[][] getFileValues() {
	return FileContent;
}

public void setFileValues(String[][] fileValues) {
	this.FileContent = fileValues;
}

public String[][] getTrainData() {
	return TrainingData;
}

public void setTrainData(String[][] trainData) {
	this.TrainingData = trainData;
}

public double[] getYesProbabilities() {
	return yesProbs;
}

public void setYesProbabilities(double[] yesProbabilities) {
	this.yesProbs = yesProbabilities;
}

public double[] getNoProbabilities() {
	return noProbs;
}

public void setNoProbabilities(double[] noProbabilities) {
	this.noProbs = noProbabilities;
}

public double getTonYes() {
	return yesTons;
}

public void setTonYes(double tonYes) {
	this.yesTons = tonYes;
}

public double getTonNo() {
	return noTons;
}

public void setTonNo(double tonNo) {
	this.noTons = tonNo;
}

public double getpTons() {
	return probTons;
}

public void setpTons(double pTons) {
	this.probTons = pTons;
}

public double getpNoTons() {
	return pronNotTons;
}

public void setpNoTons(double pNoTons) {
	this.pronNotTons = pNoTons;
}
}