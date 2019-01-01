package hackerEarthProblems;

import java.util.Scanner;

public class MonkAndSquareRoot {
    public  static  void main(String atrg[]){
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        while(testcase > 0){

            long N = sc.nextLong();
            long M = sc.nextLong();

            boolean flag = false;
            long diff = (M + N);
            double t1 = Math.sqrt(diff);

            long smallest = 1L;

            if(Math.ceil(t1) == Math.floor(t1)){
                flag = true;
                Double d1 = new Double(t1);
                smallest = d1.longValue();
               // System.out.println(d1.longValue());
            }

            double t2 = Math.sqrt(N);
            if(Math.ceil(t2) == Math.floor(t2)){
                flag = true;
                Double d2 = new Double(t2);
                if(d2.longValue() < smallest){
                    smallest = d2.longValue();
                }
            }


            if(!flag){
                System.out.println(-1);
            }else{
                System.out.println(smallest);
            }
            testcase--;
        }
    }
}
