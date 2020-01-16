package com.samples.dylanisensee;

public class CustomString {
	//Instance Variables
	private char[] values;
	private int size;
	private int capacity;
	
	//Static finals
	static final int DEFAULT_CAP=10;
	
	//Constructors
	public CustomString(){}
	
	public CustomString(char[] values){
		this.values = values;
	}
	
	
	//Methods
	public int length() {
		return values.length;
	}
	
	public boolean isEmpty() {
		return values.length == 0;
	}
	
	public char charAt(int index){
		char rValue = '0';
		if(values != null && index < values.length && values.length > 0) {
			for(int i = 0; i < values.length; i++) {
				if(i == index) {
					rValue = values[i];
				}
			}
		}else {
			System.out.println("The index either does not exist (empty array) or is out of bounds");
			rValue = '0';
		}
		return rValue;
	}
	
	
	
	
}
