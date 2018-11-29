package hackerEarthProblems;

public class MyDataStructure{
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
