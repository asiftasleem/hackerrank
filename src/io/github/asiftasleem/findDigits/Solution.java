/**
 * 
 */
package io.github.asiftasleem.findDigits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author asif
 * 
 */
public class Solution {

	/**
	 * 
	 */
	public Solution() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		HashMap<Integer, Integer> mapOfDividers = new HashMap<Integer, Integer>(s);
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
			
			Integer[] arreyOfDigits = getDigitsArray(ar[i]);			
			mapOfDividers.put(ar[i], countDivisors(ar[i], arreyOfDigits));
		}
		
		for(Integer i : ar){
			System.out.println(mapOfDividers.get(i));
		}
		

	}
	
	private static int countDivisors(int number, Integer[] digits){
		int count=0;
		for(Integer i : digits){
			if(i!=0 && number%i==0){
				count++;				
			}
		}
		
		return count;
	}
	
	private static Integer[] getDigitsArray(Integer number){
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(number>0){
			int mod = number%10;
			number = number/10;
			
			list.add(mod);
		}
		Integer[] ar = new Integer[list.size()];
		return list.toArray(ar);		
	}

}
