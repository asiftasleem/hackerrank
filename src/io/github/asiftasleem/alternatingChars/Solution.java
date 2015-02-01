package io.github.asiftasleem.alternatingChars;

import java.io.IOException;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numtest = sc.nextInt();
		
		String[] words = new String[numtest];

		for (int i = 0; i < numtest; i++) {
			words[i] = sc.next();
		}

		for(String str : words){
			char [] ar = str.toCharArray();
			
			int count = 0;
			int i=0;
			while(i<ar.length-1){
				while(i<ar.length-1 && ar[i]==ar[i+1]){
					i++;
					count++;
				}
				i++;
			}
			
			System.out.println(count);
		}
		
	}
}