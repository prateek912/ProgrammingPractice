package com.java.prac;

import com.java.fastIO.InputReader;

import java.util.Stack;

public class OptimizeMonkAndGobletOfFire {
    //static Stack<Long> stack = new Stack<>();

    public static void main(String args[]){
        InputReader reader = new InputReader(System.in);
        int repetition = reader.readInt();

        // Queue for every school
        MyDataStructure ONE = new MyDataStructure(repetition);
        MyDataStructure TWO = new MyDataStructure(repetition);
        MyDataStructure THREE = new MyDataStructure(repetition);
        MyDataStructure FOUR = new MyDataStructure(repetition);
        // Main queue, that will hold school Numbers
        MyDataStructure MAIN = new MyDataStructure(repetition);
        // This and MAIN Queue will get Combine at last
        MyDataStructure extra_QUEUE = new MyDataStructure(repetition);

        // Queue, this will store school Number
        // For above queue
        long removedRollNumber = 0;
        long removedSchoolNumber = 0;
        long rollNumber = 0;


        for (int i=0; i < repetition; i++){
            char operation = reader.readString().charAt(0);

            if('E' == operation){
                // Insertion
                int schoolNumber = reader.readInt();
                rollNumber = reader.readLong();
                // Based on this school number we have to decide where to push this coming roll number
                if(schoolNumber == 1){
                    insertToQueue(ONE,rollNumber,"One");
                }else if(schoolNumber == 2){
                    insertToQueue(TWO,rollNumber,"Two");
                }else if(schoolNumber == 3){
                    insertToQueue(THREE,rollNumber,"Three");
                }else if(schoolNumber == 4){
                    insertToQueue(FOUR,rollNumber,"Four");
                }

                /*** For Optimization ***/
                if(isEmpty(extra_QUEUE)){
                    // Then check in MAIN Queue from REAR side
                    boolean isMatched = false;
                    if(!isEmpty(MAIN)){
                        int temp = MAIN.getRear();
                        long[] queue = MAIN.getRollNumbeQueue();
                        while (temp > MAIN.getFront()) {
                            if (queue[temp] != schoolNumber) {
                                // Pop from main queue
                                long removed = deleteFromQueueRear(MAIN, "From Main Queue");
                                // System.out.println("Removed from Main queue to stack :" + removed);
                                insertToQueue(extra_QUEUE,removed,"From Main Queue to extra Queue");
                            } else {
                                insertToQueue(extra_QUEUE,queue[temp],"From Main Queue to extra Queue");
                                isMatched = true;
                                break;
                            }
                            temp--;
                        }

                        // If Nothing matches then Put whole extra_Queue to MAIN Queue
                        if(temp >= MAIN.getFront() ){
                            if(!isMatched){
                                while(!isEmpty(extra_QUEUE)){
                                    while(!isEmpty(extra_QUEUE)){
                                        long element = deleteFromQueueRear(extra_QUEUE,"From rear side of extra queue");
                                        insertToQueue(MAIN,element,"Not Matched so putting one by one..");
                                    }
                                    insertToQueue(MAIN,schoolNumber,"Moving NON matched element at last of Main Queue!!");
                                }
                            }
                        }

                    }else{
                        // Then insert into MAIN Queue from Rear Side
                        insertToQueue(MAIN,schoolNumber,"Inserting at start of Main Queue");
                    }
                }else{
                    // Same thing as above, but this time i have to start checking from FRONT Side, as that will be end of Final Queue
                    int temp_front = extra_QUEUE.getFront()+1;
                    long[] queue = extra_QUEUE.getRollNumbeQueue();
                    while(temp_front <= extra_QUEUE.getRear()){
                        if(queue[temp_front] != schoolNumber){
                            // Do nothing, keep going
                        }else{
                            // Start moving element from extra_Queue to Main Queue till matched element
                            int temp_rear = extra_QUEUE.getRear();
                            while(temp_rear >= temp_front){
                                // Keep moving from extra Queue to MAIN queue
                                long removed = deleteFromQueueRear(extra_QUEUE,"From extra_Queue to MAIN Queue");
                                insertToQueue(MAIN,removed,"To the MAIN Queue");
                                temp_rear--;
                            }
                            insertToQueue(extra_QUEUE,schoolNumber,"Moving matched element at last of extra Queue!!");
                        }
                        temp_front++;
                    }

                    if(temp_front > extra_QUEUE.getRear()){
                        // Mow we will search in MAIN Queue for matching element
                        int main_temp_rear = MAIN.getRear();
                        boolean isMatched = false;
                        long[] main_queue = MAIN.getRollNumbeQueue();
                        while(main_temp_rear > MAIN.getFront()){
                            if(main_queue[main_temp_rear] != schoolNumber){
                                long removed = deleteFromQueueRear(MAIN,"From MAIN rear..");
                                insertToQueue(extra_QUEUE,removed,"To extra Queue..");
                            }else{
                                // If Matched then insert into MAIN Queue last
                                insertToQueue(MAIN,schoolNumber,"MAtched element to MAIN ..");
                                isMatched = true;
                                break;
                            }
                            main_temp_rear--;
                        }

                        // If still nothing matched then put entire extra Queue to Main Queue
                        if(main_temp_rear >= MAIN.getFront() ){
                            if(!isMatched){
                                while(!isEmpty(extra_QUEUE)){
                                    while(!isEmpty(extra_QUEUE)){
                                        long element = deleteFromQueueRear(extra_QUEUE,"From rear side of extra queue");
                                        insertToQueue(MAIN,element,"Not Matched so putting one by one..");
                                    }
                                    insertToQueue(MAIN,schoolNumber,"Moving NON matched element at last of Main Queue!!");
                                }
                            }
                        }
                    }
                }

            }else if('D' == operation){
                // Deletion
                if(!isEmpty(MAIN)){
                    removedSchoolNumber = deleteFromQueueFront(MAIN,"Main Queue");
                }else{
                    // Take it from extra Queue
                    removedSchoolNumber =deleteFromQueueRear(extra_QUEUE,"Main Queue");
                }

                //  System.out.println("Removed Element on Pressing D :"+removedSchoolNumber);
                if(removedSchoolNumber == 1){
                    removedRollNumber = deleteFromQueueFront(ONE,"One");
                }else if(removedSchoolNumber == 2){
                    removedRollNumber = deleteFromQueueFront(TWO,"Two");
                }else if(removedSchoolNumber == 3){
                    removedRollNumber = deleteFromQueueFront(THREE,"Three");
                }else if(removedSchoolNumber == 4){
                    removedRollNumber = deleteFromQueueFront(FOUR,"Four");
                }
                System.out.println(removedSchoolNumber+" "+removedRollNumber);
                // System.out.println("Removed Roll Number ==========> "+removedRollNumber);
            }
        }
    }

    // Utility method
    public static boolean isEmpty(MyDataStructure ds){
        return (ds.getRear() == ds.getFront()) ? true : false;
    }

    public static void insertToQueue(MyDataStructure ds,long x, String msg){
        // System.out.println("For Queue :"+msg);
        int currentObjectRear = ds.getRear();
        int currentObjectFront = ds.getFront();
        long[] tempQueue = ds.getRollNumbeQueue();

        // System.out.println("Value of rear :"+currentObjectRear+" and Front :"+currentObjectFront);
        // System.out.println("RollNumber of be inserted :"+x);
        // Check for Overflow
        if(currentObjectRear != tempQueue.length){
            currentObjectRear++;
            tempQueue[currentObjectRear] = x;

            // Setting new value of Current Object
            ds.setRear(currentObjectRear);
            ds.setRollNumbeQueue(tempQueue);
        }else{
            System.out.println("Stack is OverFlow :"+msg);
        }
    }

    public static long deleteFromQueueRear(MyDataStructure ds,String msg){

        int currentObjectRear = ds.getRear();
        int currentObjectFront = ds.getFront();
        long[] tempQueue = ds.getRollNumbeQueue();

        //  System.out.println("From Object :"+msg);
        //  System.out.println("Value of Rear before removing :"+currentObjectRear);

        // Check for UnderFlow
        long removedElement = 0;
        if(currentObjectFront != currentObjectRear){
            removedElement = tempQueue[currentObjectRear];
            currentObjectRear--;

            //Setting new value to Current Object
            ds.setRear(currentObjectRear);
            ds.setRollNumbeQueue(tempQueue);
        }else{
            System.out.println("Stack is UnderFlow ");
        }
        return removedElement;
    }

    public static long deleteFromQueueFront(MyDataStructure ds,String msg){

        int currentObjectRear = ds.getRear();
        int currentObjectFront = ds.getFront();
        long[] tempQueue = ds.getRollNumbeQueue();

        //  System.out.println("Removing from :"+msg);
        //  System.out.println("Value of Front before removing :"+currentObjectFront);

        // Check for UnderFlow
        long removedElement = 0;
        if(currentObjectFront != currentObjectRear){
            currentObjectFront++;
            removedElement = tempQueue[currentObjectFront];

            // Setting new value to Curren Object
            ds.setFront(currentObjectFront);
            ds.setRollNumbeQueue(tempQueue);
        }else{
            System.out.println("Stack is UnderFlow ");
        }
        return removedElement;
    }
}

