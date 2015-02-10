package io.github.asiftasleem.anagramsLists;
import java.util.ArrayList;
import java.util.HashMap;

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
    	String[] array = { "pear","dirty room","amleth","reap","tinsel","hamlet","dormitory","listen","silent" };
    	
    	ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
    	
    	for(int i=0; i<array.length; i++){
    		
    		if(!array[i].equals("")){
    			ArrayList<String> list  = new ArrayList<String>();
    			list.add(array[i]);
    			
    			HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    			for(char c : array[i].toCharArray()){
    				if(c!=' '){
	    				Integer freq = frequencyMap.get(i);
	    				if(freq!=null){
	    					freq++;
	    					frequencyMap.put(c, freq);				
	    				}else{
	    					frequencyMap.put(c, 1);				
	    				}    
    				}
    			}
    			
	    		for(int j=i+1; j<array.length; j++){
	    			String str = array[j].replaceAll(" ", "").trim();
	    			
	    			if(str.length() == array[i].length()){
	    				boolean anagaram = true;
	        			for(char c : array[j].toCharArray()){
		    				Integer freq = frequencyMap.get(i);
		    				if(freq!=null){
		    					freq++;
		    					frequencyMap.put(c, freq);				
		    				}else{
		    					frequencyMap.put(c, 1);				
		    				} 
	        				if(frequencyMap.get(c)==null){
	        					anagaram = false;
	        					break;
	        				}
	        				
	        			}
	        			if(anagaram){
	        				list.add(array[j]);
	        				array[j] = "";
	        			}
	    				
	    			} 
	    		}
	    		
	    		listOfLists.add(list);
    		}
    		
    	}
    	
		for(ArrayList<String> list : listOfLists)
			System.out.println(list.toString());
    	
    	
    	//Trim spaces
        
    }
}















