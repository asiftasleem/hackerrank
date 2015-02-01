package io.github.asiftasleem.angryChildren;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int numPackets = sc.nextInt();
		int numKids = sc.nextInt();
		int[] packets = new int[numPackets];

		for (int i = 0; i < numPackets; i++) {
			packets[i] = sc.nextInt();
		}

		int unfairness = Integer.MAX_VALUE;
		
		Arrays.sort(packets);
		
		for(int i=0; i<numPackets-numKids; i++){			
			if(packets[i+numKids-1] - packets[i] < unfairness)
				unfairness = packets[i+numKids-1] - packets[i];
		}

		// Write your code here, to process numPackets N, numKids K, and the
		// packets of candies
		// Compute the ideal value for unfairness over here

		System.out.println(unfairness);
	}
}