package hackerEarthProblems;

import java.util.Scanner;

public class MonkAndSquareRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		
		while(testcases > 0) {
			
			long N = sc.nextLong();
			long M = sc.nextLong();
			boolean flag = false;
			
			for(int i=0; i<=M; i++) {
				long temp = (i*i)%M;
				if(temp == N) {
					flag = true;
					System.out.println(i);
					break;
				}
			}
			
			if(!flag) {
				System.out.println(-1);
			}
			
			testcases --;
		}
	}

}
