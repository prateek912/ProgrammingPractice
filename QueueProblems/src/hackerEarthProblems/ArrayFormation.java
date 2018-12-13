package hackerEarthProblems;

import com.java.fastIO.InputReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayFormation {
   static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String arg[]){
        InputReader reader = new InputReader(System.in);

        int size = reader.readInt();
        int[] arr = new int[size];

        // 2-D array
       // int[][] result = new int[size][size];
        int[] stack = new int[size];
      //  int[] queue = new int[size];
        StringBuilder str = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            arr[i] = reader.readInt();
            boolean check = checkPrime(arr[i]);
            if(check){
                str.append(arr[i]+" ");
              //  queue[i]= arr[i];
            }else{
                stack[i] = arr[i];
            }
        }

       // int[][] result = {queue,stack};
        //printArray(queue);
        System.out.print(str);
        System.out.println();
        printStack(stack);

        pw.flush();
        pw.close();

    }

    public static void printArray(int[] arr){
        for(int i : arr){
            if(i != 0){
                pw.write(i+" ");
            }
        }
        pw.println("");
    }

    public static void printStack(int[] arr){
        for(int i=arr.length-1;i >=0; i--) {
            if (arr[i] != 0) {
                pw.write(arr[i] + " ");
            }
        }
    }


    public static boolean checkPrime(int i){
       boolean flag = true;
       if(i == 2){
           return flag;
       }
       if(i%2== 1){
           double sqRoot = Math.sqrt(i);
           for(int x=2; x <= sqRoot ;x++){
               if(i%x == 0){
                   flag = false;
                   break;
               }
           }
       }else{
           flag = false;
       }
       return flag;
    }
}
