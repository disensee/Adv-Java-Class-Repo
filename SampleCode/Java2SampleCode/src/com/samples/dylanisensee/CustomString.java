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
	public int getSize() {
		int size = 0;
		for(char c : values){
			size++;
		}
		return size;
	}
	
	//***NEEDS TO BE DEFINED***
	public int getCapacity() {
		return 1;
	}
	
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
	//***NEEDS TO BE DEFINED***
	public void append(char[] values) {
		
	}
	
	public int indexOf(char c) {
		int rValue = 0;
		for(int i = 0; i < values.length; i++) {
			if(c == values[i]) {
				rValue = i;
				break;
			}else {
				rValue = -1;
			}
		}
		return rValue;
	}
	//***NEEDS TO BE DEFINED***
	public int indexOf(CustomString cs){
		return -1;
	}
	
	public int indexOf(int c) {
		int rValue = 0;
		for(int i = 0; i < values.length; i++) {
			if(c == (char)values[i]) {
				rValue = i;
				break;
			}else {
				rValue = -1;
			}
		}
		return rValue;
	}
	
	public String toString() {
		return new String(values);
	}
	
	
	
}
