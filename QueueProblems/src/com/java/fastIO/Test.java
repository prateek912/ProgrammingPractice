package com.java.fastIO;

public class Test {

	public static void main(String[] args) {
	
		InputReader reader  = new InputReader(System.in);
		OutputWriter writer = new OutputWriter(System.out);
		
		/*
		long startTime = System.currentTimeMillis();
		int i = reader.readInt();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		*/
		
		String str = reader.readString();
		String str2 = reader.readStringLine();
		
		writer.writeLine(str);
		writer.writeLine(str2);
		
		
	}

}
