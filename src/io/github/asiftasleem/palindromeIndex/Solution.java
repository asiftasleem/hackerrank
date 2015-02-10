package io.github.asiftasleem.palindromeIndex;
import java.util.Scanner;

public class Solution {

    public static void verfiyPangram(String str){
    	int[] frequency = new int[26];
    	
    	char[] letters = str.toUpperCase().toCharArray();
    	int index = 0;
    	for(char letter : letters){
            index = (int)letter;
            if(index >= 65 && index <= 91){            
                index = Character.getNumericValue(letter) % 26;
                frequency[index]++;    		
            }
    	}
    	boolean pangram = true;
    	for(int i : frequency)
    		if(i<1){
    			pangram = false;
    			break;
    		}
    	if(pangram)
    		System.out.println("pangram");    
    	else
    		System.out.println("not pangram");
        
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        String str = in.next();
        in.close();
        
        verfiyPangram(str);
    }
}