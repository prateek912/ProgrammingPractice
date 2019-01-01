package com.java.prac;

import java.util.Scanner;

public class SeiveOEratosthenes {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Considering all number till n as Prime Number
        int[] primes = new int[n];
        for(int i=0;i <n;i++){
            primes[i] = 1;
        }

        // As we know 0 and 1 are not prime number and 2 is the smallest Prime Number
        if(n > 1){
            primes[0] = 0;
            primes[1] = 0;

            // Looping through 2 to n
            for(int i=2;i<=Math.sqrt(n);i++){
                if(primes[i] == 1){
                    // Looping again and making multiple of this current primes as 0 for non prime
                    for(int j=2; j*i< n;j++){
                        // System.out.print("For i :"+i+" and J :"+j);
                        // System.out.println();
                        primes[i*j] = 0;
                    }
                }
            }

            // Whatever is left as 1 is the prime number series
            int count = 0;
            for(int i=0; i< primes.length;i++){
                if(primes[i] != 0){
                    //   System.out.print("Prime Number :"+i+" ");
                    count++;
                }
            }

            System.out.println(count);

        }else if(n == 1){
            primes[0] = 0;
            System.out.println(0);
        }

    }

}
