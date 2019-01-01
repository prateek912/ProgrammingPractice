package hackerEarthProblems;

import java.io.PrintWriter;
<<<<<<< HEAD
=======
import java.util.Scanner;
>>>>>>> faddc9ee5d0fb65b6334da4102b9c938066ffe4b
import java.util.Stack;

import com.java.fastIO.InputReader;

public class MonkandPrisonerofAzkaban {

<<<<<<< HEAD

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		InputReader reader = new InputReader(System.in); 
		
		int size = reader.readInt();
		long[] arr = new long[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readLong();
		}
		

        Stack<Integer> s = new Stack<>(); 
        int nge[] = new int[arr.length]; 
  
        Stack<Long> stack = new Stack<>();
        
        // iterate for rest of the elements  
        for (int i = arr.length - 1; i >= 0; i--) { 
              
            if (!s.empty()) { 
                while (!s.empty() && s.peek() <= arr[i]) { 
                    s.pop(); 
                } 
            } 
            nge[i] = s.empty() ? -1 : s.peek(); 
            stack.push(arr[i]); 
  
        } 
        for(int i = 0; i < arr.length; i++)  
        System.out.println(arr[i] + " --> " + nge[i]); 
		
		
		stack = new Stack<>();
		// Getting Previous Greatest Element
		long[] x = new long[size];
		x[0] = -1;
		for (int i = 0; i < x.length; i++) {
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && stack.peek() < arr[i]) {
					stack.pop();
				}
			}
			x[i] = stack.isEmpty() ? -1 : (i+1);
			stack.add(arr[i]);
		}
		
		for (int i = 0; i < x.length-1; i++) {
			System.out.println(arr[i]+" ---> "+x[i]);
		}
		
		// Closing PrintWrriter
		 out.println();
	     out.close();
	}
=======
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


>>>>>>> faddc9ee5d0fb65b6334da4102b9c938066ffe4b
}
