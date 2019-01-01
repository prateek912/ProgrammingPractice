package hackerEarthProblems;

import java.math.BigInteger;
import java.util.Scanner;

import com.java.fastIO.InputReader;

public class GreatAjitAndNumber {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		int testcases = reader.readInt();
		long M = (long) Math.pow(10, 9)+7;
		long X = 0;
		while(testcases > 0) {
			
			int size = reader.readInt();
			long[] arr = new long[size];
			long[] mainArr = new long[size-1];
			long FValue = 0L;
			long multiple = 1L;
			
			for(int i=0; i < arr.length;i++) {
				arr[i] = reader.readLong();
				if(i == 0) {
					X = arr[0];
				}
				if(i > 0) {
					mainArr[i-1]=findOrignalNumber(arr[i],X,multiple,M);
					//System.out.println("Value of Main Arr :"+mainArr[i-1]+" at position :"+i);
					multiple = modularMultiplication(multiple, mainArr[i-1],M);
					//System.out.println("Modular Multiplication :"+multiple);
					FValue = (FValue+findSummation(mainArr[i-1],M))%M;
					//System.out.println("FValue of arr["+(i-1)+"] is :"+FValue);
				}
			}
			
			//System.out.println("FValue :"+FValue);
			System.out.println(findSummation(FValue,M));
			
			testcases--;
		}
		
	}
	
	private static long findSummation(long A,long M) {
		return findModularInverseMuliplication(modularMultiplication(A,A+1,M),2,M);
	}
	
	private static long modularMultiplication(long A,long B,long M) {
		long temp = ((A%M)*(B%M))%M;
		return temp;
	}
	
	private static long findOrignalNumber(long number,long X,long multiple,long M) {
		long temp = modularMultiplication(X, multiple,M);
		return findModularInverseMuliplication(number,temp,M);
	}

	private static long findModularInverseMuliplication(long number,long temp,long M) {
		return ((number%M) * inverserModulo(temp,M))%M;
	}
	
	private static long inverserModulo(long temp,long mod) {
		long d = 1;
		long gcd = (mod - 2);
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
	
}
