package com.java.fastIO;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class OutputWriter {

	// We will need a PrintWritter to print on Console
	private PrintWriter writer;


	// Initializing writer with Constructor
	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}
	// Overloaded Constructor
	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}
	
	// Printing Method
	public void write(Object... object) {
		for (int i = 0; i < object.length; i++) {
			if(i != 0) {
				// For giving space between each object
				writer.print(' ');
			}
			writer.print(object[i]);
		}
		writer.flush();
	}
	
	// For printing in one line
	public void writeLine(Object... objects) {
		write(objects);
		writer.println();
		writer.flush();
	}
	
	public void close() {
		writer.close();
	}

	public void flush() {
		writer.flush();
	}
	
}
