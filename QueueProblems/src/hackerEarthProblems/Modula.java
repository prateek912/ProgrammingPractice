package hackerEarthProblems;

import java.util.Date;
import java.util.Scanner;

public class Modula {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        long M = sc.nextLong();

        Date finalCalStart = new Date();
        System.out.println("Final Calculation start :"+finalCalStart.getTime());

        long exp = findModularExponential(A,B,M);
        System.out.println("Modular Exponentiation :"+exp);

        long inverse = findModularInverse(C,M);
        System.out.println("Modular Inverse :"+inverse);

        long expMod = exp % M;
        long inverseMod = inverse % M;
        System.out.println((expMod * inverseMod)%M);
        Date finalCalEnd = new Date();
        System.out.println("Final Calculation end :"+finalCalEnd.getTime());
        System.out.println("Difference :"+(finalCalEnd.getTime() - finalCalStart.getTime()));
    }

    private static long findModularExponential(long A, long B, long M){
       if(B == 0){
           return 1;
       }
       if(B % 2 == 0){
           long result = findModularExponential(A,B/2,M);
           return (result*result) %M;
       }else{
            return ((A % M) * findModularExponential(A,B-1,M)) % M;
       }
    }

    private static long findModularInverse(long C,long M){
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
