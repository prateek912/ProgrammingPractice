package com.java.prac;

import java.util.Scanner;

public class FindGCD {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(usingRecursion(A,B));
        System.out.println(usingIteration(A,B));
        System.out.println(usingBinary(A,B));
    }

    // Using Recursion, not that fast
    private static long usingRecursion(long A,long B){
        // Euclid's Algorithm , GCD(A,B) = GCD(B,A%B)
        if(B == 0){
            return A;
        }
        return usingRecursion(B,A%B);
    }

    // Using Iteration, approach is same but run faster than recursion
    private static long usingIteration(long A,long B){
        if(B == 0){
            return A;
        }
        while(B > 0){
            long temp = A%B;
            A = B;
            B = temp;
        }
        return A;
    }

    // Using Binary, fastest among all as it uses bit manipulation
    private static long usingBinary(long A,long B){
        if(B == 0){
            return A;
        }
        int commonMultipleOf2 = 1;
        // If both number are Even number
        while((A & 1) == 0 && (B & 1) == 0){                      // & 1 will check last bit of Number and if it 0 then number is even
            commonMultipleOf2 = commonMultipleOf2 << 1;           // This << 1 i=opreation is equals to Multiplication of 2
            A = A >> 1;                                           // This >> 1 is equals to Division by 2
            B = B >> 1;
        }
        // When B is not even but A is
        while((A & 1) ==0){
            A = A >> 1;
        }

        while(B != 0){
            while((B & 1) == 0){
                B = B >> 1;
            }
            // Till here we made sure A and B both are ODD
            // Thus A-B Even
            long temp = A-B;
            A = B;
            B = temp;

            // If B > A then
                if(B > A){
                    // Swap A and B
                    long tempVar = A;
                    A = B;
                    B = tempVar;

                }
        }
        return A*commonMultipleOf2;
    }
}
