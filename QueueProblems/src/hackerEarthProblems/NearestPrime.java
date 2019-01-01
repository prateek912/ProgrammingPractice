package hackerEarthProblems;

import com.java.fastIO.InputReader;

import java.util.Scanner;

public class NearestPrime {

    private static long[] primes;

    public static void main(String args[]){
        InputReader reader = new InputReader(System.in);
        int testcases = reader.readInt();

        // Considering all number till n as Prime Number
        primes = new long[1000000];
        for(int i=0;i <primes.length;i++){
            primes[i] = 1;
        }

        // As we know 0 and 1 are not prime number and 2 is the smallest Prime Number
        primes[0] = 0;
        primes[1] = 0;

        // Looping through 2 to n
        for(int i=2;i<=Math.sqrt(primes.length);i++){
            if(primes[i] == 1){
                // Looping again and making multiple of this current primes as 0 for non prime
                for(int j=2; j*i< primes.length;j++){
                    // System.out.print("For i :"+i+" and J :"+j);
                    // System.out.println();
                    primes[i*j] = 0;
                }
            }
        }

        while(testcases > 0){

        long N = reader.readLong();

        long left = fromLeft(N);
        long right = fromRight(N,N-left);

        if(right == -1){
            System.out.println(left);
        }else if((right -N) == (N-left)){
            System.out.println(left);
        }else{
            System.out.println(right);
        }


            testcases--;
        }
    }

    private static long fromLeft(long N){
        while(!checkPrime(N)){
            N--;
        }
        return N;
    }

    private static long fromRight(long N,long diff){
        int count=0;
        while(!checkPrime(N)){
            N++;
            count++;
            if(count > diff){
                return -1;
            }
        }
        return N;
    }

    private static boolean checkPrime(long N){
        int index = (int) N;
       if(primes[index] == 1){
           return true;
       }else{
           return  false;
       }
    }
}
