/**
 * 
 */
package io.github.asiftasleem.firstUniqueInteger;

import java.util.LinkedHashMap;

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
//		Scanner in = new Scanner(System.in);
//		int s = in.nextInt();
		int[] ar = {2 ,6, 7, 9, 2, 6};
		LinkedHashMap<Integer, Integer> frequencyMap = new LinkedHashMap<Integer, Integer>(ar.length);
				
		for(Integer i : ar){
			Integer freq = frequencyMap.get(i);
			if(freq!=null){
				freq++;
				frequencyMap.put(i, freq);				
			}else{
				frequencyMap.put(i, 1);				
			}
		}
		
		for(Integer i : frequencyMap.keySet()){
			if(frequencyMap.get(i)==1){
				System.out.println(i);
				break;
			}
		}

	}

}
