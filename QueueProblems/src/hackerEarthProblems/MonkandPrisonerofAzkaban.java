package hackerEarthProblems;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

import com.java.fastIO.InputReader;

public class MonkandPrisonerofAzkaban {

	// Global variable
	static int top = -1;
	static long[] stack;
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		InputReader reader = new InputReader(System.in);
		int size = reader.readInt();
		long[] array = new long[size];

		// Two array for X and Y
		long[] X = new long[size];
		long[] Y = new long[size];

		for(int i=0; i<array.length;i++){
			array[i] = reader.readLong();
			if(i == 0) {
				// as first element will be -1
				X[i] = -1;
			}else {
				int temp = i;
				while(temp >= 0 && array[temp] <= array[i]) {
					temp--;
				}
				X[i]=(temp < 0) ? -1 : temp+1;
			}
		}

		Stack<Integer> s = new Stack<>();
		for (int i = array.length-1; i >= 0; i--) {
			while (!s.empty()) {
				int p = s.peek();
				if (array[i] > array[p]) { s.pop(); Y[p] = i+1; }
				else break;
			}
			s.push(i);
		}
		while (!s.empty()) { int p = s.pop(); Y[p] = -1; }

		for(int i = 0; i < size; i++) {
			out.print(X[i] + Y[i]);
			if (i != size-1) out.print(" ");
		}

	}


}
