/**
 * 
 */
package io.github.asiftasleem.removeDuplicates;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Asif
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	

		int[] array = new int[]{30,2, 30,10,2,45,32,1,23,4,23};
		
		//LinkedHashSet is durable as it maintains the order in which elements are added.
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(int i: array){
		    set.add(i);
		}
		System.out.println(set);	
	}

}
