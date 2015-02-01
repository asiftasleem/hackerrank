package io.github.asiftasleem.maxXor;

import java.io.IOException;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int xor = Integer.MIN_VALUE;
		while(l<r){
			int _xor = l ^ r;
			if(_xor > xor){
				xor = _xor;
			}			
			l++;
			r--;			
		}

		System.out.println(xor);
	}
}