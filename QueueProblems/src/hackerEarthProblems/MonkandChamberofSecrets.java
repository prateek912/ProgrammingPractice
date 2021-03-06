package hackerEarthProblems;

import java.util.Scanner;

public class MonkandChamberofSecrets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfSpider = sc.nextInt();
		int spiderToBeSelected = sc.nextInt();
		
		int[] initialQueue = new int[numberOfSpider];
		for (int i = 0; i < initialQueue.length; i++) {
			initialQueue[i] = sc.nextInt();
		}
		
		int[] extraQueue = new int[numberOfSpider];
		
		// Performing iteration
		while(spiderToBeSelected > 0) {
			
			if(spiderToBeSelected == 0) {
				// Checking size of queue is greater or less than number to be dequeue
				if(initialQueue.length > numberOfSpider) {
					// Putting in a different queue and finding highest power
					int highestPower = 0;
					int firstindex = 0;
					// To capture first encounter of highest power element
					boolean flag = false;
					for (int i = 0; i < numberOfSpider; i++) {
							if(highestPower < initialQueue[i]) {
								highestPower = initialQueue[i];
								if(!flag) {
									firstindex = i;
								}
								flag = true;
							}
					}
				}else {
					
				}
			}
			
			spiderToBeSelected--;
		}
	}

}
