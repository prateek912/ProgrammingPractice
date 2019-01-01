package hackerEarthProblems;


import com.java.fastIO.InputReader;

public class MonkAndDivisorConundrum {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int size = reader.readInt();
		long[] arr = new long[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readLong();
		}
		
		
		int start = 0; 
		int end = arr.length; 
		// As taking last element as pivot by default
		quick_sort(arr,start,end-1);
		printArray(arr);
		
		int testcases = reader.readInt();
		
		while(testcases > 0) {
			long P = reader.readLong();
			long Q = reader.readLong();
			
			long smallerNumber = 0L;
			if(P >= Q) {
				smallerNumber = Q;
			}else {
				smallerNumber = P;
			}
			System.out.println("Smaller Number is :"+smallerNumber);
			int count = 0;
			
			for(int i=0;i<arr.length;i++) {
				long N = arr[i];
				if(N == smallerNumber || N > smallerNumber) {
					
					if(N == P) {
						count++;
						continue;
					}else if(N > P) {
						if(N % P == 0) {
							count++;
							continue;
						}
					}
					if(N == Q) {
						count++;
						continue;
					}else if(N > Q) {
						if(N % Q == 0) {
							count++;
							continue;
						}
					}
				}else {
					continue;
				}
			}
			System.out.println(count);
			testcases--;
		}
	}

	// Recursive function
		public static void quick_sort(long arr[],int start,int end) {
			// Condition for recursive algorithm function
			if(start < end) {
				// Find random pivot element and swapping it with the first element  
				int pivot = partition(arr, start, end);
				quick_sort(arr,start,pivot-1);
				// Sorting right side of pivot, should not include pivot element
				quick_sort(arr,pivot+1,end);
			}
		}
		
		public static int partition(long arr[], int start, int end) {
			
			// Taking last element of array as pivot
			long pivot = arr[end];
			// for keeping index of where to swap pivot after one iteration
			int i = start -1;
			
			for(int j=start; j<end; j++) {
				if(arr[j] <= pivot) {
					i++; // This will finally will give place to put pivot value after one iteration
					long temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
			// Putting pivot at its place after putting all small element on left with help of i variable
			long temp = arr[i+1];
			arr[i+1] = arr[end];
			arr[end] = temp;
			
			// returning the new position of pivot after replacements
			return i+1;
		}
		public static void printArray(long arr[]) {
			for(long i : arr) {
				//writer.write(i+" ");
				System.out.print(i+" ");
			} 
		}
}
