/**
 * 
 */
package io.github.asiftasleem.utopiaTree;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
		int[] cycles = new int[numTests];
        int[] heights = new int[numTests]; 
        
        for(int c=0;c<numTests;c++)
        	cycles[c] =  sc.nextInt();

		for (int i = 0; i < cycles.length; i++) {
            int height = 1;
			if(cycles[i] == 0){
                heights [i] = 1;                
            }else{
                for(int j=1; j<=cycles[i];j++){
                    if(j%2==1)
                        height *= 2;
                    else
                        height += 1;
                }
                heights [i] = height;                 
            }
		}
        
        for(int h : heights)
            System.out.println(h);
    }
}