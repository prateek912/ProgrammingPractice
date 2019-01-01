package hackerEarthProblems;

<<<<<<< HEAD
import java.util.Scanner;

public class AGameOfNumber {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
		
	}

}

/* Not the Optimize way
 * 
 * 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			int temp = i+1;
			boolean found = false;
			while(temp<arr.length) {
				if(arr[i] < arr[temp]) {
					found = true;
					break;
				}
				temp++;
			}
		
			if(found && temp != arr.length) {
				//System.out.println("NGE is found at :"+temp+" and its value :"+arr[temp]);
				boolean foundAgain = false;
				int j = temp+1;
				while(j<arr.length) {
					if(arr[temp] > arr[j]) {
						foundAgain = true;
						System.out.print(arr[j]+" ");
						break;
					}
					j++;
				}
				if(!foundAgain) {
					System.out.print(-1+" ");
				}
			}else{
				System.out.print(-1+" ");
			}
			
			
		}
		
	}
 * 
 * */
=======
import com.java.fastIO.InputReader;

import java.util.Scanner;
import java.util.Stack;

public class AGameOfNumber {
    public static void main(String args[]){
       // Scanner sc = new Scanner(System.in);
        InputReader reader = new InputReader(System.in);
        int size = reader.readInt();

        int[] arr = new int[size];
        int[] nge = new int[size];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            arr[i] =  reader.readInt();
        }

        for(int i=arr.length-1; i>=0; i--){
            int element = arr[i];
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= element){
                    stack.pop();
                }
            }
            nge[i] = stack.isEmpty()? -1 :  stack.size()-1;
            stack.push(element);
        }


        for(int i=0; i < arr.length; i++){
            System.out.print(nge[i]+" ");
        }

    }
}
>>>>>>> faddc9ee5d0fb65b6334da4102b9c938066ffe4b
