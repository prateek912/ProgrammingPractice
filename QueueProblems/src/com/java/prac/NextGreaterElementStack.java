package com.java.prac;

import java.util.Scanner;

import com.java.fastIO.InputReader;

public class NextGreaterElementStack {

	static int top = -1;
	static long[] stack;
	
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in); 
		int size = reader.readInt();
		
		long[] array = new long[size];
		stack = new long[size];
		
		for(int i=0; i < array.length; i++) {
			array[i] = reader.readLong();
		}
		
		long next = 0;
		long element = 0;
		
		for(int i=0; i<array.length;i++) {
			next = array[i];
			//System.out.println("Next is :"+next);
			if(!isEmpty()) {
				
				// Pop element from stack array and compare
				element = popFromStack();
				
				while(element < next) {
					System.out.println("Found NGE for :"+element+" and its NGE is :"+next);
					// Check if it is not empty
					if(isEmpty()) {
						break;
					}
					element = popFromStack();
				}
				
				if(element > next) {
					// then insert element into stack
					pushToStack(element);
				}
				
			}else {
				// Push to stack
				//System.out.println("Stack is empty, pushing element...");
				pushToStack(array[i]);
			}
			
			// At last put the next to stack to find its NGE
			if(i != 0) {
				pushToStack(next);
			}
		}
		
		
		// Now all those element that are left in stack does not have NGE, so put -1 for them
		while(!isEmpty()) {
			element = popFromStack();
			next = -1;
			System.out.println(" NO NGE for element :"+element +" thus NGE is :"+next);
		}
		
	}
	
	public static long popFromStack() {
		long poppedElement = 0;
		if(!isEmpty()) {
			 poppedElement = stack[top];
			top--;
			//System.out.println("Popped Element :"+poppedElement);
		}else {
			System.out.println("Stack is empty!!");
		}
		//printStack(stack,"After pop...");
		return poppedElement;
	}
	
	public static void pushToStack(long x) {
		//System.out.println("Value of Top is :"+top);
		if(top != stack.length) {
			stack[++top] = x;
		}else {
			System.out.println("Stack is Full!!");
		}
		//printStack(stack,"After Push..");
	}
	
	public static boolean isEmpty() {
		return (top == -1) ? true : false;
	}
	
	public static void printStack(long[] stack, String msg) {
		System.out.println(msg);
		for(long l : stack) {
			System.out.print(l+" ");
		}
		System.out.println();
	}
}
