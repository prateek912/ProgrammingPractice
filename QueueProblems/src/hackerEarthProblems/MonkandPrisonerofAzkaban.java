package hackerEarthProblems;

import java.util.Scanner;

import com.java.fastIO.InputReader;

public class MonkandPrisonerofAzkaban {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in); 
		int size = reader.readInt();
		int top=-1;
		
		long[] array = new long[size];
		for (int i = 0; i < array.length; i++) {
			long element = reader.readLong();
			int x = 0;
			if(top == -1) {
				//push element to stack, if array is empty
				top++;
				pushToStack(array,top,element);
				x = -1;
				System.out.println("Value of x :"+x);	
			}else {
				// Keep popping from stack until greater element found
				long[] tempArray = array;
				int tempTop = top;
				x = keepPopping(tempArray,tempTop,element);
				System.out.println("Value of x :"+x);
				
				// then push to stack
				top++;
				pushToStack(array,top,element);
			}
			
		}
	
		
	}
	
	public static void pushToStack(long[] array,int top, long element) {
		// Check if stack is not full already
		if(top != array.length) {
			array[top] = element;
		}else {
			System.out.println("Stack is full!!");
		}
	}
	
	public static int keepPopping(long[] array, int top, long element) {
		//System.out.println("Top value :"+top);
		if(top == -1) {
			return -1;
		}		
		//System.out.println("Comparing :"+element+" and "+array[top]);
		if(array[top] > element) {
			return top+1;
		}
		top--;
		return keepPopping(array, top, element);
	}
	
	
	
	
	
	/*	
	for (int i = 0; i < array.length; i++) {
		int x = 0;
		int y = 0;
		// Finding value of x 
		if(i > rear) {
			boolean flag = true;
			for(int j = i-1; j > -1; j--) {
				//System.out.println("Value of J :"+j);
				//System.out.println("Comparing for x :"+array[j]+" and :"+array[i]);
				if(array[j] > array[i]) {
					x = j+1;
					flag= false;
					break;
				}
			}
			if(flag) {
				x = -1;
			}
		}else {
			//System.out.println("I smaller than rear and value of i is :"+i);
			x = -1;
		}
		
		// Finding value of y
		if(front > i) {
			boolean flag = true;
			for(int j=i+1; front > j;j++) {
				//System.out.println("Value of J :"+j);
				//System.out.println("Comparing for y :"+array[j]+" and :"+array[i]);
				if(array[j] > array[i]) {
					y = j+1;
					flag= false;
					break;
				}
			}
			if(flag) {
				y = -1;
			}
		}else {
			//System.out.println("I Greater than front and value of i is :"+i);
			y = -1;
		}
		
		//System.out.println("Value of x :"+x+" and y :"+y);
		System.out.print((x+y)+" ");
		
	}
	*/

}
