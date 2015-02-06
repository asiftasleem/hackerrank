package io.github.asiftasleem.testBooking;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\r\n");
		String value = sc.next();
		String indices = sc.next();
		
		Integer[] valueAr = convertToSortedArrayOfIntegers(value);
		Integer[] indicesAr = convertToSortedArrayOfIntegers(indices);
		//Arrays.sort(indicesAr);
		
		
		for(Integer i : indicesAr){
			valueAr[i] = Integer.MIN_VALUE;			
		}
		
		for(Integer i : valueAr){
			if(i != Integer.MIN_VALUE)
				System.out.print(i + " ");
		}				

		
	}
	
	private static Integer[] convertToSortedArrayOfIntegers(String values){
		String[] moreValues = values.split(" ");
		Integer[] ar = new Integer[moreValues.length];
		for(int i=0; i<moreValues.length; i++){
			ar[i] = Integer.parseInt(moreValues[i]);
		}
		return ar;
	}
}
