package hackerEarthProblems;

import com.java.fastIO.InputReader;

import java.util.Scanner;
import java.util.Stack;

public class MonkAndGobletOfFire {

    static Stack<Long> stack = new Stack<>();

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

                // Inserting School Number in main queue
                if(!isEmpty(MAIN)) {
                  //  System.out.println("Position of rear from MAIN before traversing :" + MAIN.getRear());
                    int temp = MAIN.getRear();
                    long[] queue = MAIN.getRollNumbeQueue();
                    while (temp > -1) {
                        if (queue[temp] != schoolNumber) {
                            // Pop from main queue
                            long removed = deleteFromQueueRear(MAIN, "From Main Queue");
                           // System.out.println("Removed from Main queue to stack :" + removed);
                            stack.add(removed);
                        } else {
                            stack.add(queue[temp]);
                            break;
                        }
                        temp--;
                    }

                    // Add everything back from stack to Queue
                    while (!stack.isEmpty()) {
                        long element = stack.peek();
                        insertToQueue(MAIN, element, "Main Queue from stack");
                        stack.pop();
                    }
                    if (temp == -1){
                        insertToQueue(MAIN, schoolNumber, "Inserting at the end of Main Queue");
                     }

                }else{
                    insertToQueue(MAIN,schoolNumber,"Inserting at start of Main Queue");
                }

            }else if('D' == operation){
                // Deletion
                removedSchoolNumber = deleteFromQueueFront(MAIN,"Main Queue");
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


class MyDataStructure{
    private int rear;
    private int front;
    private long[] rollNumbeQueue;

    // Parameter Constructor for initializing long array
    public MyDataStructure(int size){
        rollNumbeQueue = new long[size];
        rear = -1;
        front = -1;
    }

    // Getters
    public int getRear(){
        return rear;
    }
    public int getFront() {
        return front;
    }
    public long[] getRollNumbeQueue() {
        return rollNumbeQueue;
    }

    // Setters
    public void setFront(int front) {
        this.front = front;
    }
    public void setRear(int rear) {
        this.rear = rear;
    }
    public void setRollNumbeQueue(long[] rollNumbeQueue) {
        this.rollNumbeQueue = rollNumbeQueue;
    }

    @Override
    public String toString() {
        return "Rear :"+rear+" Front :"+front+" RollNumberQueue :"+rollNumbeQueue.toString();
    }
}