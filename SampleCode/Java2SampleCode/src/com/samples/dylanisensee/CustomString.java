package com.samples.dylanisensee;

import java.util.Arrays;

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
	
	//***NEEDS TO BE DEFINED*** (DONE ?)
	public int getCapacity() {
		int capacity = values.length;
		return capacity;
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
	
	public boolean equals(java.lang.Object obj) {
		boolean rValue = false;
		CustomString cs = obj != null ? (CustomString)obj : null;
		if(cs == null) {
			rValue = false;
		}
		
		for(int i = 0; i < values.length; i++) {
			for(int j = 0; j < cs.values.length; j++) {
				if(values[i] != cs.values[j]) {
					rValue = false;
				}else {
					rValue = true;
				}
			}
		}
		return rValue;
	}
	//***NEEDS TO BE DEFINED***
	public void append(char[] values) {
		char[] appendedValue = new char[this.values.length + values.length];
		
		for(int i = 0; i < this.values.length; i++) {
			appendedValue[i] = this.values[i];
			for(int x = this.values.length; x < this.values.length + values.length; x++) {
				appendedValue[x] = values[x];
			}
		}
		this.values = appendedValue;
	}
	//***NEEDS TO BE DEFINED***
	public void resize(int newCap) {
		if(newCap < values.length) {
			System.out.println("The new capacity is not larger than the current capacity");
		}else {
			char[] newCapArr = new char[newCap];
			for(int i = 0; i < values.length; i++) {
				newCapArr[i] = values[i];
			}
			values = newCapArr;
		}
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
		int rValue = 0;
		if(this.length() < cs.length()) {
			System.out.println("Invalid entry");
			rValue = -1;
		}else {
			rValue = 1;
		}
		
		return rValue;
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
	
	public CustomString toUpperCase() {
		CustomString ucCustomString = new CustomString();
		for(int i = 0; i < values.length; i++) {
			if(Character.isLetter(values[i]) && Character.isLowerCase(values[i])) {
				values[i] = Character.toUpperCase(values[i]);
			}
		}
		return ucCustomString;
	}
	
	public String toString() {
		return new String(values);
	}
	
	
	
}
