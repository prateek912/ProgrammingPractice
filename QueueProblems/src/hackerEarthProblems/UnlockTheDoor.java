package hackerEarthProblems;

import java.util.Scanner;

public class UnlockTheDoor {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		long M = (long) Math.pow(10, 9)+7;
		while(testcases > 0) {
			
			long result = 1L;
			long N = sc.nextLong();
			long T = sc.nextLong();
		
			if(N == 1) {
				System.out.println(T);
			}else {
				for(int i=0;i < N;i++) {
					result = result*T;
					result = result%M;
					T -=1;
				}
				System.out.println(result);
			}
			
			
			testcases --;
		}
	}
	
}
