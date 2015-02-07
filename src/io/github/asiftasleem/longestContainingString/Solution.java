package io.github.asiftasleem.longestContainingString;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

    public static String getLongestContainingWord(String[] strArray, char[] characters){ 
    	Arrays.sort(strArray, new LengthComparator());
    	String found = null;
    	for(String str : strArray){
    		char[] chars = str.toCharArray(); 
    		TreeSet<Character> set = new TreeSet<Character>();
    		for(char c : chars)
    			set.add(c);
    		
    		boolean contains = true;
    		for(char c : characters){
    			if(!set.contains(c))
    				contains = false;
    		}
    		
    		if(contains){
    			found = str;
    			break;
    		}
    		
    	}
    	
    	return found;
    }


    public static void main(String[] args) {
    	
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int i=0;i<n;i++){
//            ar[i]=in.nextInt();
//        }
//        in.close();
        String[] strList = {"abc","abcdef","abcdefghi","abcdefghijkl","abdefghijklmno"};
        char[] characters = {'a','b','c', 'z'};
        String str = getLongestContainingWord(strList, characters);
        System.out.println(str);
    }
}
