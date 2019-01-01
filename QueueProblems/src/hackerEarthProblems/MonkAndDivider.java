package hackerEarthProblems;

import com.java.fastIO.InputReader;

import java.io.PrintWriter;

public class MonkAndDivider {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int size = reader.readInt();
        long[] arr = new long[size];

        PrintWriter pw = new PrintWriter(System.out);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.readLong();
        }

        int testcases = reader.readInt();

        while(testcases > 0) {
            long P = reader.readLong();
            long Q = reader.readLong();

            long MUL = P * Q;
            //	System.out.println("Smaller Number is :"+smallerNumber);
            int count = 0;

            for(int i=0;i<arr.length;i++) {
                long N = arr[i];
                if(MUL != 0){
                    if(N % MUL == 0){
                        count++;
                    }else if(N % P == 0){
                        count++;
                    }else if(N % Q == 0){
                        count++;
                    }
                }
            }
            pw.write(count+" \n");
            testcases--;
        }
        pw.flush();
        pw.close();
    }

}
