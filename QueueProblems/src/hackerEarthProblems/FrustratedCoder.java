package hackerEarthProblems;

<<<<<<< HEAD
import java.util.Iterator;
=======
import com.java.fastIO.InputReader;

>>>>>>> faddc9ee5d0fb65b6334da4102b9c938066ffe4b
import java.util.Scanner;
import java.util.Stack;

public class FrustratedCoder {
<<<<<<< HEAD

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] circle = new int[size];
		
		for (int i = 0; i < circle.length; i++) {
			circle[i] = sc.nextInt();
		}
		
		// selecting a pivot randomly
		int start = 0; 
		int end = circle.length; 
		// As taking last element as pivot by default
		quick_sort(circle,start,end-1); 
		
		Stack<Integer> stack = new Stack<>();
		int[] finalArray = new int[size];
		
		for (int i = 0; i < circle.length; i++) {
			int element  = circle[i];
			if(!stack.isEmpty()) {
				int popElement = stack.pop();
				while(!stack.isEmpty() && popElement >= element) {
					
				}
				stack.push(element);
			}else {
				stack.push(circle[i]);
			}
		}
		
		long sum = 0;

		//printArray(circle);
	}
	
	// Recursive function
	public static void quick_sort(int arr[],int start,int end) {
		// Condition for recursive algorithm function
		if(start < end) {
			// Find random pivot element and swapping it with the first element  
			int pivot = partition(arr, start, end);
			quick_sort(arr,start,pivot-1);
			// Sorting right side of pivot, should not include pivot element
			quick_sort(arr,pivot+1,end);
		}
	}
	
	public static int partition(int arr[], int start, int end) {
		
		// Taking last element of array as pivot
		int pivot = arr[end];
		// for keeping index of where to swap pivot after one iteration
		int i = start -1;
		
		for(int j=start; j<end; j++) {
			if(arr[j] <= pivot) {
				i++; // This will finally will give place to put pivot value after one iteration
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		// Putting pivot at its place after putting all small element on left with help of i variable
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		
		// returning the new position of pivot after replacements
		return i+1;
	}

	public static void printArray(int arr[]) {
		for(int i : arr) {
			//writer.write(i+" ");
			System.out.print(i+" ");
		} 
	}
=======
    public static void main(String argd[]){
        InputReader reader = new InputReader(System.in);
    // Scanner sc = new Scanner(System.in);
    int size = reader.readInt();
    int[] circle = new int[size];

        for(int i=0; i<circle.length; i++){
        circle[i] = reader.readInt();
    }

    int start = 0;
    int end = circle.length;
    quick_sort(circle,start,end-1);

    Stack<Integer> stack = new Stack<>();
    int largest = circle[size-1];
    int index = size-1;

        for(int x = circle.length-1; x > 0; x--){
        if(stack.isEmpty() || (largest == circle[x]))
            stack.push(circle[x]);
        else{
            index--;
            largest = circle[index];
        }
    }

    int sum = 0;
        while(!stack.isEmpty())
    sum += stack.pop();

        System.out.println(sum);


}

    // Recursive function
    public static void quick_sort(int arr[],int start,int end) {
        // Condition for recursive algorithm function
        if(start < end) {
            // Find random pivot element and swapping it with the first element
            int pivot = partition(arr, start, end);
            quick_sort(arr,start,pivot-1);
            // Sorting right side of pivot, should not include pivot element
            quick_sort(arr,pivot+1,end);
        }
    }

    public static int partition(int arr[], int start, int end) {

        // Taking last element of array as pivot
        int pivot = arr[end];
        // for keeping index of where to swap pivot after one iteration
        int i = start -1;

        for(int j=start; j<end; j++) {
            if(arr[j] <= pivot) {
                i++; // This will finally will give place to put pivot value after one iteration
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Putting pivot at its place after putting all small element on left with help of i variable
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        // returning the new position of pivot after replacements
        return i+1;
    }
>>>>>>> faddc9ee5d0fb65b6334da4102b9c938066ffe4b
}
