package io.github.asiftasleem.delta;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
	
	private static SortedSet<String> set = new TreeSet<String>();	
	
	private static int totalCalls = 0;

	public static void main(String[] args) {
		
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */			
			
		Scanner sc = new Scanner(System.in);		
		String value = sc.next();	
		
		permute(value);
		
		for (String str : set)
			System.out.println(str);
		
		System.out.println(totalCalls);
		

		
	}
	
	public static void permute(String str) { 
		permute("", str); 
	}

	private static void permute(String prefix, String str) {
		totalCalls++;
	    int n = str.length();
	    if (n == 0) 
	    	set.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	        	permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
