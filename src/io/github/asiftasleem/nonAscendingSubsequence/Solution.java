package io.github.asiftasleem.nonAscendingSubsequence;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static ArrayList<ArrayList<Integer>> getNonAscendingSubSequences(int[] array){
    	ArrayList<ArrayList<Integer>> allSequences = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> sequence = null;
    	for(int i=0; i<array.length; i++){
    		sequence = new ArrayList<Integer>();;
    		sequence.add(array[i]);
    		int j = i+1;
    		
    		while(j<array.length && sequence.get(sequence.size()-1) <= array[j]){
    			sequence.add(array[j]);
    			j++;
    		}
    		i = j-1;
    		allSequences.add(sequence);   		
    	}    	
    	
    	return allSequences;
    }


    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> allSequence = null;
    	
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int i=0;i<n;i++){
//            ar[i]=in.nextInt();
//        }
//        in.close();
        int[] ar = {3,6,61,6,7,9,1,7,7,2,7,7,2,388,3,72,7};
        allSequence = getNonAscendingSubSequences(ar);
        
        for(ArrayList<Integer> seq : allSequence){
        	for(Integer i : seq)
        		System.out.print(i + " ");
        	System.out.println();
        }
    }
}