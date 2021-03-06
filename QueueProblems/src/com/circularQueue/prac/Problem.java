package com.circularQueue.prac;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int times = sc.nextInt();
		int[] queue = new int[times];
		
		int front = 0;
		int rear = 0;
		int count = 0;
		while(times > 0) {
			String str = sc.next();
			if("E".equalsIgnoreCase(str)) {
				int element = sc.nextInt();
				pushToQueue(element,rear,queue.length,queue);
				rear++;
				count++;
				System.out.println(count);
			}else if("D".equalsIgnoreCase(str)) {
				int deletedElement = popFromQueue(front,rear,queue.length,queue);
				if(deletedElement != -1) {
					count--;
					front++;
				}
				System.out.println(deletedElement+" "+(count));
			}
			
			times--;
		}
	}
	
	public static void pushToQueue(int element, int rear, int size,int[] queue) {
		// Check to see if Queue is full
		if(rear != size) {
			queue[rear] = element;
		}else {
			//System.out.println("Queue is OverFlowed!!");
		}
	}
	
	public static int popFromQueue(int front, int rear, int size, int[] queue) {
		int deletedElement = 0;
		// Check to see if it is not already empty
		if( front != rear ) {
			deletedElement = queue[front];
		}else {
			deletedElement = -1;
		}
		return deletedElement;
	}

}
