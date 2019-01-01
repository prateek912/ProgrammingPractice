package com.java.prac;

import java.util.Scanner;

public class ModularExponentiation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        // With Modulus
        long M = 5;

        System.out.println(usingRecursion(A,B,M));
        System.out.println(usingIteration(A,B,M));
    }

    // Using Recursion
    private static long usingRecursion(long A,long B,long M){
        // If power is 0 then it will be 1 always
        if(B == 0){
            return 1;
        }
        // Check if Power is even or odd
        if((B & 1) == 0){
            long temp = usingRecursion(A,B/2,M);
            return (temp*temp) %M;
        }else{
            return ((A % M) * usingRecursion(A,B-1,M)) % M;
        }
    }

    // Iterative Approach
    private static long usingIteration(long A,long B,long M){
        long result = 1L;
        if(B == 0){
            return 1;
        }
        if(B == 1){
            return A%M;
        }
        while(B > 0){
            if( (B & 1) != 0){
                // For One extra A times in result
                result = (result * A) % M;
            }
            A = (A*A) % M;
            B /= 2 ;
        }
        return result;
    }

}
