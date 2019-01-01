package hackerEarthProblems;

import java.util.Scanner;

public class RiyaBirthday {
    public static void main(String arfs[]){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        long M = (long) Math.pow(10,9)+7;
        while(testCases > 0){

            long n = sc.nextLong();
            n = n%M;
            long result = getNumber(n,M);
            System.out.println(result);
            testCases --;
        }
    }

    private static long getNumber(long n,long M){
       return (n*(2*n-1))%M;
    }
}
