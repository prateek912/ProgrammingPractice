package com.java.prac;

import java.util.Scanner;
import java.util.Stack;

public class TheStockPanProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] array = new int[size];
		int[] stack = new int[size];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		Stack<Integer> st = new Stack<>();
		st.push(0);
		
		// Span value of first element is always -1
		stack[0] = -1;
		
		for (int i = 1; i < stack.length; i++) {
			System.out.println("Value of stack peek :"+st.peek());
			while(!st.isEmpty() && array[st.peek()] <= array[i]) {
				System.out.println("Popped from stack :"+st.pop());
			}
			int value = (st.empty())? (i + 1) : (i - st.peek());
			System.out.println("Value to be in array :"+value+" at position :"+i);
			
			st.push(i);
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		
	}

}
