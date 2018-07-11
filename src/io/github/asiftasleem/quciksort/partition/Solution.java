package io.github.asiftasleem.quciksort.partition;
/**
 * Solution for a creating a partition based on the pivot 
 * Where the pivot is the first element in the array
 */

/**
 * @author mtasleem
 *
 */
import java.io.IOException;

public class Solution {

	// Complete the quickSort function below.
	static int[] quickSort(int[] arr) {

		   int pivot = arr[0]; // Choose the first element as the pivot
		    int i = 1; // Index for forward search
		    int j = arr.length - 1; // Index for backward search

		    while (j > i) {
		      // Search forward from left
		      while (i <= j && arr[i] <= pivot)
		        i++;

		      // Search backward from right
		      while (i <= j && arr[j] > pivot)
		        j--;

		      // Swap two elements in the list
		      if (j > i) {
		        int temp = arr[j];
		        arr[j] = arr[i];
		        arr[i] = temp;
		      }
		    }

		    while (j > 0 && arr[j] >= pivot)
		      j--;

		    // Swap pivot with list[high]
		    if (pivot > arr[j]) {
		      arr[0] = arr[j];
		      arr[j] = pivot;
		  
		    }
		    return arr;
		  }

	public static void main(String[] args) throws IOException {

		int[] arr = new int[] { 0, -3, 6, 4, -10, 8, -5, 2, -7 };

		int[] result = quickSort(arr);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
