/**
 * 
 */
package io.github.asiftasleem.minimumSwaps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author mtasleem
 *
 */

class Pair<K, V> {
	private K key;
	private V value;

	Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	public String toString() {
		return key + "-"  + value;
	}
}

public class Solution {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int n = arr.length;

		// Create two arrays and use as pairs where first
		// array is element and second array
		// is position of first element
		ArrayList<Pair<Integer, Integer>> arrpos = new ArrayList<Pair<Integer, Integer>>();
		for (int i = 0; i < n; i++)
			arrpos.add(new Pair<Integer, Integer>(arr[i], i));

		// Sort the array by array element values to
				// get right position of every element as the
				// elements of second array.
		Collections.sort(arrpos, new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				if (o1.getKey() > o2.getKey())
					return 1;

				// We can change this to make it then look at the
				// words alphabetical order
				else if (o1.getKey().equals(o2.getKey()))
					return 0;

				else
					return -1;
			}
		});
		

		// To keep track of visited elements. Initialize
		// all elements as not visited or false.
		Boolean[] vis = new Boolean[n];
		Arrays.fill(vis, false);

		// Initialize result
		int ans = 0;

		// Traverse array elements
		for (int i = 0; i < n; i++) {
			// already swapped and corrected or
			// already present at correct pos
			if (vis[i] || arrpos.get(i).getValue() == i)
				continue;

			// find out the number of node in
			// this cycle and add in ans
			int cycle_size = 0;
			int j = i;
			while (!vis[j]) {
				vis[j] = true;

				// move to next node
				j = arrpos.get(j).getValue();
				cycle_size++;
			}

			// Update answer by adding current cycle.
			ans += (cycle_size - 1);
		}

		// Return result
		return ans;

	}

	public static void main(String[] args) {

		int[] arr = { 4, 3, 1, 2 };

		int res = minimumSwaps(arr);

		System.out.println(res);
	}
}
