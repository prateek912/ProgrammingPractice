package main;

public class Search {

	public static void main(String[] args) {
		int[] arr = {10,12,13,14,15,16,17,18,19};
		int result =search(9,arr);
		 System.out.println("Index is :"+result);
	}
	
	static int search(int key, int[] arr) {
	
		int low = 0;
		int high= arr.length-1;
		int mid=(low+high)/2;
		System.out.println("Initial mid value is :"+mid);
		int result =-1;
		while(low <= high) {
			if(key == arr[mid]){
				result = mid;
				System.out.println("Key is equal to mid value !!");
				break;
			}else if(key > arr[mid] ){
				System.out.println("Key is greater than mid value");
				low = mid+1;
				mid=(low+high)/2;
				System.out.println("New Mid :"+mid+" Low :"+low+" High :"+high);
			}else if(key < arr[mid]){
				System.out.println("Key is less than mid value");
				high = mid-1;
				mid=(low+high)/2;
				System.out.println("New Mid :"+mid+" Low :"+low+" High :"+high);
			}else{
				result= -1;
			}
		}
		return result;
	}
}
