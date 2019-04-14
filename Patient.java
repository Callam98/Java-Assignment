package com.Assignment.OOP;

public class Patient {
	
	private String throat;
	private String temp;
	private String aches;
	private int ID = 0;
	
	public Patient(String temp,String aches,String throat)
	{
		this.throat = throat;
		this.temp = temp;
		this.aches = aches;
		this.ID = ID;
		ID++;
	}
	public double pCheck()
	{
		FileProcessor F1 = new FileProcessor();
		return F1.probsCalc(temp,aches,throat);
	}
	public String getThroat() {
		return throat;
	}
	public void setThroat(String throat) {
		this.throat = throat;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getAches() {
		return aches;
	}
	public void setAches(String aches) {
		this.aches = aches;
	}
	public int getPatientID() {
		return ID;
	}
	public void setPatientID(int patientID) {
		this.ID = ID;
	}

}
