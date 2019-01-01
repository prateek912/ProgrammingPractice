package hackerEarthProblems;

import java.io.PrintWriter;
import java.util.Stack;

import com.java.fastIO.InputReader;

public class MonkandPrisonerofAzkaban {


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
}
