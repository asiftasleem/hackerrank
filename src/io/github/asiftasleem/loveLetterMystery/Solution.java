package io.github.asiftasleem.loveLetterMystery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numWords = sc.nextInt();
		
		ArrayList<String> words = new ArrayList<String>(numWords);
		HashMap<String, Integer> actions = new HashMap<String, Integer>(numWords);

		String str;
		for (int i = 0; i < numWords; i++) {
			str = sc.next();
			words.add(str);			
			actions.put(str, calculateActions(str));
		}		

		// Write your code here, to process numPackets N, numKids K, and the
		// packets of candies
		// Compute the ideal value for unfairness over here
		for(String word : words){
			System.out.println(actions.get(word));
		}
		
	}
	
	private static int calculateActions(String word){
		char[] ar = word.toCharArray();
		
		int i=0;
		int j=ar.length-1;
		
		int count = 0;
		while(i<j){
			
			if(ar[i] < ar[j]){
				count = count + (ar[j] - ar[i]);				
			}else if(ar[j] < ar[i]){
				count = count + (ar[i] - ar[j]);				
			}			
			i++;
			j--;
		}
				
		
		return count;
	}
}