package hackerEarthProblems;

import java.math.BigInteger;
import java.util.Scanner;

public class TheConfuesedMonk {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long M = (long) Math.pow(10,9)+7;
        int size = sc.nextInt();
        long arr[] = new long[size];

        long A = 1L;

        for(int i=0; i <arr.length;i++){
            arr[i] = sc.nextLong();
            A = findModulusMultiplicative(A,arr[i],M);
        }

        long B = 1L;

        if(arr.length == 1){
            B = arr[0];
        }else{
            B = findGCDOfArray(arr);
        }

      long finalAnswer = findModularExponential(A,B,M);
        System.out.println("GCD :"+B);
        System.out.println("F(x) :"+A);

        System.out.println(finalAnswer);

    }

    private static long findModulusMultiplicative(long A,long B,long M){
        return ((A%M)*(B%M))%M;
    }

    private static long findModularExponential(long A,long B,long M){
        if(B == 0){
            return 1;
        }
        if(B % 2 ==0){
            long temp = findModularExponential(A,B/2,M);
            return (temp*temp) %M;
        }else{
            return ((A%M) * findModularExponential(A,B-1,M)) % M;
        }
    }

    private static long findGCDOfArray(long[] arr){
        long x = arr[0];

        for(int i=1; i<arr.length;i++){
            x = gcd(x,arr[i]);
        }
        return  x;
    }

    private static long gcd(long a,long b){
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
