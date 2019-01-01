package hackerEarthProblems;

import java.util.Scanner;

public class HackerDecrypt {
    public static void main(String aeg[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long Q = sc.nextLong();

        long[] arr = new long[N];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextLong();
        }


        while(Q > 0){

            long X = sc.nextLong();
            int i=0;
            boolean flag = false;
            while(i < arr.length){
                System.out.println("Checking with :"+arr[i]);
                if(arr[i] != 0){
                    flag = checkSemiPrime(X);
                    if(!flag){
                        while(X % arr[i] == 0){
                            long quotient = X/arr[i];
                            flag = checkSemiPrime(quotient);
                            if(flag){
                                break;
                            }
                            X = quotient;
                        }
                    }
                }

                System.out.println("Flag value after checking :"+flag);
                if(flag)
                    break;

               i++;
            }

            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

            Q--;
        }


    }

    private static boolean checkSemiPrime(long X){
        int count = 0;
        for(long temp=2;count <2 && temp*temp<=X;temp++){
            while(X % temp == 0){
                X /=temp;
                count++;
            }
        }

        // If count is 1 that mean number is prime number, so incremewnt by 1 as it will itself be a factor
        if(X > 1){
            count++;
        }
        System.out.println("Count value for Number is :"+count);
        return count == 2 ? true : false;
    }
}
