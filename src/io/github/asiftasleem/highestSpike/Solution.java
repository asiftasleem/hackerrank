package io.github.asiftasleem.highestSpike;

import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {

    public static Double getHighestSpike(int[] array){
    	TreeMap<Double, ArrayList<Integer>> common = new TreeMap<Double, ArrayList<Integer>>();
    	
    	for(int i=0; i<array.length; i++){
    		ArrayList<Integer> spike = new ArrayList<Integer>();
    		Integer sum = 0;
    		Integer n = 0;
    		
    		spike.add(array[i]);
    		int j = i+1;
    		
    		while(j<array.length && spike.get(spike.size()-1) <= array[j]){
    			spike.add(array[j]);
    			j++;
    			sum += array[i]; 
    			n++;
    		}
    		
    		while(j<array.length && spike.get(spike.size()-1) >= array[j]){
    			spike.add(array[j]);
    			j++;
    			sum += array[i]; 
    			n++;
    		}
    		i = j-1;
    		
    		double mean = sum/n;
    		common.put(getStandardDeviation(spike, mean), spike);
    	}
    	
    	return common.lastKey();
    }
    
    private static double getStandardDeviation(ArrayList<Integer> list, double mean){
    	double variance = 0;
    	for(Integer i : list){
    		variance = variance + Math.pow(i-mean, 2);
    	}    	
    	double std = Math.sqrt(variance/list.size());
    	return std;
    }

    public static void main(String[] args) {
    	
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int i=0;i<n;i++){
//            ar[i]=in.nextInt();
//        }
//        in.close();
        int[] graphData = {1,3,19,12, 3, -2, -5, 2, 15, 18};
        double x = getHighestSpike(graphData);
        System.out.print(x + " ");
    }
}