package io.github.asiftasleem.isFibo;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int numberOfTests = sc.nextInt();
		if (numberOfTests > 0) {
			int[] values = new int[numberOfTests];
			HashMap<Integer, Boolean> truthMap = new HashMap<Integer, Boolean>(numberOfTests);

			int max = Integer.MIN_VALUE;

			for (int i = 0; i < numberOfTests; i++) {
				values[i] = sc.nextInt();
				truthMap.put(values[i], false);
				if (values[i] > max)
					max = values[i];
			}

			int first = 0;
			int second = 1;

			if (truthMap.get(second) != null)
				truthMap.put(second, true);
			if (truthMap.get(first) != null)
				truthMap.put(first, true);

			int third = 1;
			do {
				third = first + second;
				if (truthMap.get(third) != null)
					truthMap.put(third, true);

				first = second;
				second = third;

			} while (third <= max);

			if (truthMap.get(second) != null)
				truthMap.put(second, true);
			if (truthMap.get(first) != null)
				truthMap.put(first, true);

			for (int i = 0; i < numberOfTests; i++) {
				if (truthMap.get(values[i]) == true)
					System.out.println("IsFibo");
				else
					System.out.println("IsNotFibo");

			}

		}
	}
}
