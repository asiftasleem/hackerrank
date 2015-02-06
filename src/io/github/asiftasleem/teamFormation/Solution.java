package io.github.asiftasleem.teamFormation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(new File("e:/input.txt"));
		//Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\r\n");
		
		int numberOfTests = sc.nextInt();
		if (numberOfTests > 0) {
			ArrayList<Integer[]> values = new ArrayList<Integer[]>(numberOfTests);

			for (int i=0; i<numberOfTests; i++) {
				String line = sc.next();
				values.add(convertToSortedArrayOfIntegers(line));				
			}
			
			for(Integer[] ar : values){
				
				int minTeamSize = Integer.MAX_VALUE;
				
				if(ar.length==0){
					minTeamSize = 0;					
				}else if(ar.length==1){
					minTeamSize = 1;					
				}else{
					int i=0;
					while(i<ar.length){
						Set<Integer> teamOfSkills = new HashSet<Integer>();
						while((ar[i+1]-ar[i])==1){
							teamOfSkills.add(ar[i]);
							teamOfSkills.add(ar[i+1]);
							i++;
							if(i==ar.length-1){
								if((ar[i]-ar[i-1])==1){
									teamOfSkills.add(ar[i]);
									teamOfSkills.add(ar[i-1]);
								}
								break;								
							}
						}
						
						i++;
						
						if(i==ar.length-1){
							if((ar[i]-ar[i-1])==1){
								teamOfSkills.add(ar[i]);
								teamOfSkills.add(ar[i-1]);
							}else
								minTeamSize = 1;							
							break;								
						}
						
						if(teamOfSkills.size()<minTeamSize)
							minTeamSize = teamOfSkills.size();						
						
					}
				}
				
				System.out.println(minTeamSize);
				
			}
		}
	}
	
	private static Integer[] convertToSortedArrayOfIntegers(String values){
		String[] moreValues = values.split(" ");
		Integer[] ar = new Integer[moreValues.length-1];
		for(int i=1; i<moreValues.length; i++){
			ar[i-1] = Integer.parseInt(moreValues[i]);
		}
		
		Arrays.sort(ar);
		return ar;
	}
}