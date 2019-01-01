package com.java.prac;

import java.util.Scanner;

public class ModularInverseExponentiation {
    public static void main(String areg[]){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long M = 1L;

        //  According to Extended Euclid's Algo
        // there exists two coefficient of number A and B such that
        // A.x + B.y = GCD(A,B)
        // Here x is inverse of A and Y is inverse of B

        // For a Number to have modulus inverse it should satisfy GCD(A,B) = 1
        // ex. inverse of c --> C(power of -1) % M is only possible when GCD(C,M) = 1
        // *** And Modulo Inverse of Number will always lies between [1,M-1] ***

        System.out.println(usingBruteForce(A,M));
        // Another way to find modulo inverse is Extended Euclid's Algo
        //System.out.println(usingExtenedEuclidAlgo(A,M));
    }

    // Brute Force method, time complexity will depend on size of M
    private static long usingBruteForce(long C,long M){
        long result = 1L;
        C = C%M;
        for(result=1; result < M; result++){
            if((C*result)%M == 1){
                break;
            }
        }
        return result;
    }


}
