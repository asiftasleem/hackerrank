/**
 * 
 */
package io.github.asiftasleem.subArraySum;

import java.util.Arrays;

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
		int[] array ={2,3,-4,5,6,7};
		
		findSubArrayThatSumsTo(array, 11);

	}
	
	public static int[] findSubArrayThatSumsTo(int[] array, int S) {
	    int sum = 0;
	    int j = 0;
	    boolean found = false;
	    int i;
	    for (i = 0; i < array.length; i++) {
	        sum += array[i];
	        while (sum > S) {
	        	sum-=array[j];
	        	j++;
	        }
	        if (sum == S) {
		        System.out.format("Sum (%d) found between indices %d and %d\n", S, j, i);
		        found = true;
		        break;
	        }
	    }
	    if(found)
	    	return Arrays.copyOfRange(array, j, i);
	    return null;
	}

}
