package hackerEarthProblems;

import java.math.BigInteger;
import java.util.Scanner;

public class Modulo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();
		long M = sc.nextLong();

		long modularExp  = findModularExponential(A, B, M);
		//System.out.println("MOdular Exponential :"+modularExp);
		long inverse = findModularMultiplicativeInverse(C, M);
		//System.out.println("Inverse :"+inverse);
		
		System.out.println((modularExp * inverse) % M);
		
	}

	private static long findModularExponential(long A, long B, long M) {
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

	private static long findModularMultiplicativeInverse(long C ,long M) {
		/*long B = 1l;
		C = C % M;
		
		for(B = 1; B < M; B++) {
			if((C*B)%M == 1) {
				break;
			}
		}
		return B;*/
		
		BigInteger b1 = new BigInteger(C+"");
		BigInteger b2 = new BigInteger(M+"");
		
		BigInteger b3 = b1.modInverse(b2);
		//System.out.println(b3.longValue());
		return b3.longValue();
	}
	
	
	/*
	 *  Fastest way to find inverseModulo
	 * 
	 * private static long inverse(long temp) {
		long d = 1;
		int gcd = mod - 2;
		while (gcd > 0) {
			if (gcd % 2 == 0) {
				temp = temp * temp;
				if (temp >= mod) {
					temp %= mod;
				}
				gcd /= 2;
			} else {
				d = d * temp;
				if (d >= mod) {
					d %= mod;
				}
				gcd--;
			}
		}
		return d;
	}
	 * 
	 * 
	 * */
	
}
