package hackerEarthProblems;

import java.util.Scanner;

public class MonkAndDivisible {
    public static void main(String ategp[]) {
        Scanner sc = new Scanner(System.in);
        long M = (long) Math.pow(10, 9) + 7;
        int testcases = sc.nextInt();

        while (testcases > 0) {

            long A = sc.nextLong();
            long B = sc.nextLong();
            long C = sc.nextLong();

            long Exp = findModularExponential(B, C, M);
            long inverse = findModularInverse(A,Exp);
            System.out.println("Exponential :"+Exp);
            System.out.println(inverse);
            testcases--;
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

    private static long findModularExponential(long B, long C, long M) {
        if(C == 0){
            return 1;
        }

        if(C == 1){
            return B;
        }

        if(C % 2 == 0){
            long temp = findModularExponential(B,C/2,M);
            return (temp*temp) % M;
        }else {
            return ((B%M) * findModularExponential(B,C-1,M)) % M;
        }

    }

}
