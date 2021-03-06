package com.pratice.stack;

import java.util.Scanner;

public class Main {

	static char[] parantheseArray = null;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();

		while (times > 0) {
			String str = sc.next();
			char[] chArr = str.toCharArray();
			// TODO: Can be improved
			parantheseArray = new char[chArr.length];

			// For TOP element
			int top = 0;
			boolean balanced = false;

			for (char c : chArr) {
				if (checkOpenParantheses(c)) {
					pushOperation(c, top, chArr.length);
					top++;
				} else if (checkCloseParantheses(c)) {
					balanced = popOperation(c, top);
					top--;
				}
			}

			if (balanced) {
				System.out.println("Parentheses are balanced!!!");
			} else {
				System.out.println("Parentheses are NOT balanced!!!");
			}
			times--;
		}

	}

	public static void pushOperation(char c, int top, int size) {
		// Check if stack is not full already
		if (top != (size - 1)) {
			parantheseArray[top] = c;
			System.out.println("Pushed value :" + parantheseArray[top]);
		} else {
			System.out.println("Stack is full!!!");
		}
	}

	public static boolean popOperation(char c, int top) {
		// Check if stack is not empty
		boolean flag = false;
		if (top != 0) {
			// Check for balanced parentheses
			char ch = parantheseArray[top - 1];
			System.out.println("Popped value :" + c+" and value from top:"+ch);
			if (ch == '{' && c == '}') {
				System.out.println("Mathced!!");
				flag = true;
			}else if(ch == '[' && c == ']') {
				System.out.println("Mathced!!");
				flag = true;
			}else if(ch == '(' && c == ')') {
				System.out.println("Mathced!!");
				flag = true;
			}

		} else {
			System.out.println("Stack is Empty!!");
		}

		return flag;
	}

	public static boolean checkOpenParantheses(char c) {
		switch (c) {
		case '{':
			return true;

		case '[':
			return true;

		case '(':
			return true;

		default:
			return false;
		}
	}

	public static boolean checkCloseParantheses(char c) {
		switch (c) {
		case '}':
			return true;

		case ']':
			return true;

		case ')':
			return true;

		default:
			return false;
		}
	}

}
