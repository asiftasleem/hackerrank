package io.github.asiftasleem.minimalCommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {

    public static Integer getMinimalCommon(int[] array1, int[] array2){
    	HashMap<Integer, Integer> common = new HashMap<Integer, Integer>();
    	TreeSet<Integer> commons = new TreeSet<Integer>();
    	
    	for(int x : array1){
    		common.put(x, x);
    	}
 
    	for(int x : array2){
    		if(common.get(x)!=null)
    			commons.add(x);
    	}
    	
    	return commons.first();
    }


    public static void main(String[] args) {
    	
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int i=0;i<n;i++){
//            ar[i]=in.nextInt();
//        }
//        in.close();
        int[] ar = {3,5,7,8,11,25};
        int[] ar1 = {10, 11, 5, 30, 35};
        int x = getMinimalCommon(ar, ar1);
        System.out.print(x + " ");
    }
}