package io.github.asiftasleem.almostSorted;

import java.util.Scanner;

public class Solution {

    public static void verfiySort(int[] array){
    	int swapCount = 0, l = 0, r = 0;
    	int j = 0;
    	int inverseRegion = 0;
        int regionLength = 1;
    	boolean recorded = false;
        for(int i = 0; i < array.length-1; i++){
        	j = i+1;
        	while(j < array.length && array[i]>array[j]){
        	   swapCount++;
                regionLength++;
        	   if(swapCount==1 && !recorded){
        		   l = i+1;
        		   r = l+1;
        		   recorded = true;        		   
        	   }
        	   j++;
           }
        	if(regionLength>2){
        		inverseRegion++;
     		   l = i;
     		   r = j;
        		
        	}
        	i=j;
            regionLength = 1;
        }
        
        if(swapCount==0)
        	System.out.println("yes");
        else if(swapCount==1){
        	System.out.println("yes");
        	System.out.format("swap %d %d", l, r);
        }else if(swapCount>1 && inverseRegion == 1){
        	System.out.println("yes");
        	System.out.format("reverse %d %d", l, r);
        }else{
        	System.out.println("no");        	
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        in.close();
        
        verfiySort(ar);
    }
}