package hackerEarthProblems;

import com.java.fastIO.InputReader;

import java.util.*;

public class FightForLaddu {
    public static void main(String args[]){
        InputReader reader = new InputReader(System.in);
        int repetition = reader.readInt();

        while(repetition > 0){

            int size = reader.readInt();
            long[] arr = new long[size];
            long[] arrFreq = new long[size];

            Map<Long,Integer> map = new HashMap<>();

            for(int i=0;i<arr.length;i++){
                arr[i] = reader.readLong();
                if(map.containsKey(arr[i])){
                    int temp = map.get(arr[i]);
                    map.put(arr[i],++temp);
                }else{
                    map.put(arr[i],1);
                }
            }
            // Have to Find out NGE in Frequency
            Stack<Long> stack = new Stack<>();
            Stack<Integer> indexStack = new Stack<>();
            Stack<Integer> finalStack = new Stack<>();
            int tempIndex = 0;
            // Making Frequency Array for all element
            for(int i=arr.length-1;i>=0;i--){
                arrFreq[i] = map.get(arr[i]);
                long element = arrFreq[i];

                if (!stack.isEmpty()) {
                    while (!stack.isEmpty() && stack.peek() <= element) {
                        stack.pop();
                        indexStack.pop();

                    }
                }

                if(stack.isEmpty()){
                    finalStack.add(-1);
                }else{
                    finalStack.add((int)arr[indexStack.peek()]);
                }

                stack.push(element);
                indexStack.push(i);


            }

            StringBuilder sb = new StringBuilder();
            while(!finalStack.isEmpty()){
                sb.append(finalStack.pop()+" ");
            }
            System.out.println(sb);

            repetition--;
        }



    }
}
