package com.java.fastIO;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class InputReader {

	private InputStream stream;
	private int curChar;
	private int numChars;
	private byte[] buf = new byte[1024];
	
	
	//Constructor to initialize stream
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
	
	//Defining SpaceCharacter 
	// We can make our own space character
	public boolean ignoreChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	
	// For reading Whole line of String
	public boolean ignoreStringLineChar(int c) {
		return  c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	
	
	// To read
	public int read() {
		if (numChars == -1) {
			throw new InputMismatchException();
		}
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0) {
				return -1;
			}
		}
		return buf[curChar++];
	}
	
	
	//To read Integer 
	public int readInt() {
		int ch = read();
		
		// This loop is to Ignore all the spaces present in initial position
		while(ignoreChar(ch)) {
			// If it is a Ignore Character then continue to read on other
			ch = read();
		}
		
		// Defining a variable SIGN to know Integer is Negative or Positive
		// Taking it Positive Initially
		int sign = 1;
		
		if(ch == '-' ) {
			// If first character is negative that mean integer is negative
			sign  = -1;
			
			//reading next character
			ch = read();
		}
		
		//Making a loop to read character one by one until it counter ignore character
		int result = 0;
		do {
			// To make sure integer is always between 0-9, not any alphabet
			if (ch < '0' || ch > '9') {
				throw new InputMismatchException();
			}
			
			result *= 10;
			result += ch - '0';
			ch = read();
			
		}while(!ignoreChar(ch));
		
		//Finally sending Computed Integer
		return result*sign;
		
	}
	
	
	// To read Byte
	public byte readByte() {
		int ch = read();
		while(ignoreChar(ch)) {
			ch = read();
		}
		int sign = 1;
		
		if(ch == '-' ) {
			sign  = -1;
			ch = read();
		}
		
		byte result = 0;
		do {
			// To make sure integer is always between 0-9, not any alphabet
			if (ch < '0' || ch > '9') {
				throw new InputMismatchException();
			}
			
			result *= 10;
			result += ch - '0';
			ch = read();
			
		}while(!ignoreChar(ch));
		return (byte) (result*sign);
	}
	
	
	// To read Long
	public long readLong() {
		int ch = read();
		while(ignoreChar(ch)) {
			ch = read();
		}
		int sign = 1;
		
		if(ch == '-' ) {
			sign  = -1;
			ch = read();
		}
		
		long result = 0;
		do {
			// To make sure integer is always between 0-9, not any alphabet
			if (ch < '0' || ch > '9') {
				throw new InputMismatchException();
			}
			
			result *= 10;
			result += ch - '0';
			ch = read();
			
		}while(!ignoreChar(ch));
		return (long) (result*sign);
	}
	
	
	// To read String till it encounter space
	public String readString() {
		int ch = read();
		while(ignoreChar(ch)) {
			ch = read();
		}
		
		// Have to append character by character in a StringBuilder and then return it in form of String
		StringBuilder sb = new StringBuilder();
		do {
			sb.appendCodePoint(ch);
			ch = read();
		}while(!ignoreChar(ch));
		
		return sb.toString();
	}
	
	// To read String till it encounter new line
	public String readStringLine() {
		int ch = read();
		while(ignoreChar(ch)) {
			ch = read();
		}
		
		// Have to append character by character in a StringBuilder and then return it in form of String
		StringBuilder sb = new StringBuilder();
		do {
			sb.appendCodePoint(ch);
			ch = read();
		}while(!ignoreStringLineChar(ch));
		
		return sb.toString();
	}
}
