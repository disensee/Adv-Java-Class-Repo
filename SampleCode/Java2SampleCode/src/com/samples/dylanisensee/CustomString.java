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
		for(int i = 0; i < values.length; i++){
			if(values[i] != '\u0000' ) {
			size++;
			}
		}
		return size;
	}
	
	public int getCapacity() {
		int capacity = values.length;
		return capacity;
	}
	
	
	public void append(char[] values) {
		char[] appendedValue = new char[this.values.length + values.length];
		
		for(int i = 0; i < this.values.length; i++) {
			appendedValue[i] = this.values[i];
		}
			for(int x = 0; x < values.length; x++) {
				 appendedValue[x + this.values.length] = values[x];
				}
		this.values = appendedValue;
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
	
	public boolean equalsIgnoreCase(CustomString cs) {
		boolean rValue = false;
		if(cs == null) {
			rValue = false;
		}else {
			for(int i = 0; i < values.length; i++) {
				if((int)values[i] == (int)cs.values[i] || (int)values[i] + 32 == (int)cs.values[i] || (int)values[i] - 32 == (int)cs.values[i]){
					rValue = true;
				}else {
					rValue = false;
					break;
				}
			}
		}
		return rValue;
	}
	
	public int compareTo(CustomString cs) {
		int rValue = 0;
		if(cs == null) {
			rValue = 1;
		}else if (values.length < cs.values.length) {
			rValue = -1;
		}else if (values.length > cs.values.length) {
			rValue = 1;
		}else{
			for(int i = 0; i < values.length; i++) {
				if((int) values[i] == (int)cs.values[i]) {
					continue;
				}else if((int)values[i] < (int)cs.values[i]) {
					rValue = -1;
				}else {
					rValue = 1;
				}
			}
		
		}
		return rValue;
	}
	
	public boolean startsWith(CustomString prefix) {
		boolean rValue = false;
		if(prefix == null || this.values.length < prefix.values.length) {
			rValue = false;
		}else {
			for(int i = 0; i < prefix.values.length; i++) {
				if(values[i] == prefix.values[i]) {
					rValue = true;
				}else {
					rValue = false;
				}
			}
		}
		return rValue;
	}
	
	public boolean endsWith(CustomString suffix) {
		boolean rValue = false;
		if(suffix == null || suffix.length() > this.length()) {
			rValue = false;
		}else {
			for(int i = values.length - suffix.values.length; i < values.length; i++) {
				if(suffix.values[0] == values[i]) {
					for(int x = 1; x < suffix.length(); x++) {
						if(suffix.values[x] == values[i + x]) {
							rValue = true;
						}
						break;
					}
				}
			}
		}
		return rValue;
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
	
	public int indexOf(CustomString cs){
		int rValue = -1;
		if(this.length() < cs.length()) {
			System.out.println("Invalid entry");
			rValue = -1;
		}else {
			for(int i = 0; i < values.length; i++) {
				if(values[i] == cs.values[0]) {
					for(int x = 1; x < cs.values.length; x++) {
						if(cs.values[x] == values[x+i]) {
							rValue = i;
						}else {
							rValue = -1;
							break;
						}
					}
				}
			}
		}
		
		return rValue;
	}
	
	public int indexOf(int c) {
		int rValue = 0;
		for(int i = 0; i < values.length; i++) {
			if(c == (int)values[i]) {
				rValue = i;
				break;
			}else {
				rValue = -1;
			}
		}
		return rValue;
	}
	
	public CustomString substring(int beginIndex, int endIndex) {
		char[] newValues = new char[endIndex - beginIndex];
		if(values.length < beginIndex || values.length < endIndex) {
			System.out.println("Index is out of range");
			newValues= null;
		}else {
			for(int i = beginIndex; i < endIndex; i++) {
				newValues[i] = this.values[i];
			}
		}
		return new CustomString(newValues);
	}
	
	
	public CustomString replace(CustomString target, CustomString replacement) {
		CustomString rCs = new CustomString(this.values);
		char[] newValue = new char[rCs.values.length];
		for(int i = 0; i < rCs.values.length; i++) {
			newValue[i] = rCs.values[i];
			if(target.values[0] == rCs.values[i]) {
				for(int j = 0; j < replacement.values.length; j++) {
					newValue[i] = replacement.values[j];
					i++;
				}
			}
		}
		rCs.values = newValue;
		return rCs;
	}

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
	
	public boolean contains(CustomString cs) {
		boolean rValue = false;
		if(this.values.length < cs.values.length) {
			System.out.println("This CustomString is smaller than the argument. Invalid Entry");
			rValue = false;
		}else {
			for(int i = 0; i < values.length; i++) {
				if(cs.values[0] == values[i]) {
					for(int x = 1; x < cs.values.length; x++) {
						if(cs.values[x] == values[x + i]) {
							rValue = true;
						}else {
							rValue = false;
							break;
						}
					}
				} 
			}
		}
		return rValue;
	}

	public CustomString toUpperCase() {
		CustomString ucCustomString = new CustomString();
		ucCustomString.values = this.values;
		for(int i = 0; i < ucCustomString.values.length; i++) {
			char lowerCase = ucCustomString.values[i];
			int upperCaseASCII = (int)lowerCase - 32;
			ucCustomString.values[i] = (char)upperCaseASCII;
		}
		return ucCustomString;
	}
	
	public String toString() {
		return new String(values);
	}
	
	public char[] toCharArray() {
		char[] rCharArr = new char[this.getSize()];
		for(int i = 0; i < values.length; i++) {
			if(values[i] != '\u0000') {
				rCharArr[i] = values[i];
			}else {
				rCharArr[i] = '\u0000';
			}
		}
		return rCharArr;
	}
	
	
	
}
