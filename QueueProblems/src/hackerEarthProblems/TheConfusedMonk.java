package hackerEarthProblems;

import java.util.Scanner;

public class TheConfusedMonk {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		long M = (long) (Math.pow(10, 9)+7);
		long arr[] = new long[size];
		long f = 1L;
		for(int i=0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
			f = f * arr[i];
		}
		long result = findGCDOfArray(arr);
		//System.out.println("GCD of array :"+result);
		
		
		System.out.println(findModularExponential(f,result,M));
		
	}
	
	private static long findModularExponential(long A,long B,long M) {
		long result = 1L;
		while (B > 0) {
			if ((B & 1) != 0) {
				result = (A * result) % M;
			}
			A = (A * A) % M;
			B /=2;
		}
		return result;
	
	}
	
	private static long findGCDOfArray(long[] arr) {
		long a = arr[0];
		long result = 1L;
		if(arr.length == 1) {
			return a;
		}
		for(int i=1; i < arr.length; i++) {
			result = gcd(a,arr[i]);
		}
		return result;
	}
	
	private static long gcd(long a,long b) {
		if (b == 0)
			return a;
		if (b == 1)
			return 1;
		while (b != 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

}
