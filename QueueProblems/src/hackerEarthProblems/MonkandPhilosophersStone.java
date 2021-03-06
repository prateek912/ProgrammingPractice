package hackerEarthProblems;

import java.util.Scanner;

public class MonkandPhilosophersStone {

	static int top = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfCoin = sc.nextInt();
		
		int[] harryBag = new int[numberOfCoin];
		int[] monkBag = new int[numberOfCoin];
		
		for (int i = 0; i < harryBag.length; i++) {
			harryBag[i] = sc.nextInt();
		}
			
		int repeatTimes = sc.nextInt();
		int totalAmount = sc.nextInt();
		int harryBagCoin = 0;
		int monkBagTotal = 0;
		int totalCoinInMonkBag = 0;
		
		while(repeatTimes > 0) {
			
			String str = sc.next();
			if("Harry".equalsIgnoreCase(str)) {
				// Take first coin present and throw to monk bag
				int thowCoinToMonk = harryBag[harryBagCoin];
				System.out.println("Coin to be passed to Monk:"+thowCoinToMonk);
				monkBagTotal = monkBagTotal+thowCoinToMonk;
				totalCoinInMonkBag++;
				// Store this coin in Monk Bag
				if(monkBagTotal != totalAmount) {
					pushToMonkBag(thowCoinToMonk,numberOfCoin,monkBag);
				}else {
					System.out.println(totalCoinInMonkBag);
				}
				harryBagCoin++;
			}else if("Remove".equalsIgnoreCase(str)) {
				// Remove the last entered coin from monk bag
				int removedCoin=popFromMonkBag(numberOfCoin,monkBag);
				System.out.println("Removed Coin from Monk bag :"+removedCoin);
				monkBagTotal = monkBagTotal - removedCoin;
				totalCoinInMonkBag--;
			}
			System.out.println("postion of Top in stack :"+top);
			System.out.println("Total amount in Monk Bag :"+monkBagTotal);
			repeatTimes--;
		}
		
	}

	public static void pushToMonkBag(int coin, int size, int[] stack) {
		// Check if it is already full 
		if(top != size) {
			top++;
			stack[top] = coin;
		}
	}
	
	public static int popFromMonkBag(int size,int[] stack) {
		// Check if it is already empty
		System.out.println("Removing from position :"+top);
		int removedCoin = 0;
		if(top != 0) {
			removedCoin = stack[top];
			top--;
		}
		return removedCoin;
	}
}
