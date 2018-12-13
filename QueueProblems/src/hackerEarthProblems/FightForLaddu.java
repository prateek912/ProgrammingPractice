package hackerEarthProblems;

import java.util.*;

public class FightForLaddu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int repetition = sc.nextInt();
        while(repetition > 0){

            int size = sc.nextInt();
            long[] arr = new long[size];
            long[] arrFreq = new long[size];

            Map<Long,Integer> map = new HashMap<>();

            for(int i=0;i<arr.length;i++){
                arr[i] = sc.nextInt();
                if(map.containsKey(arr[i])){
                    int temp = map.get(arr[i]);
                    map.put(arr[i],++temp);
                }else{
                    map.put(arr[i],1);
                }
            }

            // Making Frequency Array for all element
            for(int i=0;i<arr.length;i++){
                arrFreq[i] = map.get(arr[i]);
            }

           /* for(long i : arrFreq){
                System.out.print(i+" ");
            }*/

            // Have to Find out NGE in Frequency
            Stack<Long> stack = new Stack<>();
            int[] nge = new int[size];

            for(int i=arr.length-1; i >=0; i--) {
                long element = arrFreq[i];
                int temp = i;
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty() && stack.peek() <= element) {
                        stack.pop();
                        temp++;
                    }
                }
                nge[i] = stack.isEmpty() ? -1 : (temp + 1);
                stack.push(element);
            }

            System.out.println();
            for(int i=0;i<nge.length;i++){
                if(nge[i] == -1){
                    System.out.print(-1+" ");
                }else{
                    System.out.print(arr[nge[i]]+" ");
                }

            }


            repetition--;
        }



    }
}
