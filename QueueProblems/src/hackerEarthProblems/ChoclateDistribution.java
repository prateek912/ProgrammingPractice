package hackerEarthProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ChoclateDistribution {
    public static void  main(String aregs[]){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while(testCases > 0){

            // For the case when K is greater than Number of Student
            long total = 0;

            int numberOfQueues = sc.nextInt();
            int makeStudentHappy = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>();


            while(numberOfQueues > 0){
                int size = sc.nextInt();
             //   System.out.println("Size of queue :"+size);
                int[] arr = new int[size];
              //  System.out.println("Array Length :"+arr.length);
                for(int i=0;i<arr.length;i++){
                    long value = sc.nextLong();
                   // System.out.println("Entered value :"+value+" on index :"+i);
                    list.add(value);
                    total = total+value;
                }
                numberOfQueues--;
            }

            // Sorting the list
            Collections.sort(list);

            Iterator<Long> itr = list.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next()+" ");
            }

            // Checking for How many student we have to make happy
            if(list.size() > makeStudentHappy){
                long minimumChoclates = total;
               // System.out.println("Minimum Choclate initially :"+minimumChoclates);
                int diff = list.size() - makeStudentHappy;
              //  System.out.println("Difference :"+diff);
              //  System.out.println("Size of list :"+list.size());
                for(int i=list.size()-1; i>=list.size()-diff;i--){
                   // System.out.print("Value from list :"+list.get(i)+" ");
                    minimumChoclates = minimumChoclates - list.get(i);
                }
                System.out.println(minimumChoclates);
            }else{
                System.out.println(total);
            }

            testCases--;
        }

    }
}
