package hackerEarthProblems;

import com.java.fastIO.InputReader;

import java.util.Scanner;
import java.util.Stack;

public class AGameOfNumber {
    public static void main(String args[]){
       // Scanner sc = new Scanner(System.in);
        InputReader reader = new InputReader(System.in);
        int size = reader.readInt();

        int[] arr = new int[size];
        int[] nge = new int[size];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            arr[i] =  reader.readInt();
        }

        for(int i=arr.length-1; i>=0; i--){
            int element = arr[i];
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= element){
                    stack.pop();
                }
            }
            nge[i] = stack.isEmpty()? -1 :  stack.size()-1;
            stack.push(element);
        }


        for(int i=0; i < arr.length; i++){
            System.out.print(nge[i]+" ");
        }

    }
}
