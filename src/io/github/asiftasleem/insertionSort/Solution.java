package io.github.asiftasleem.insertionSort;import java.io.*;
import java.util.*;

public class Solution {
    
    public static void insertIntoSorted(int[] ar, int index) {
       if(index>0){
         int num = ar[index];
       
         int j = index;

            while(j > 0 && num < ar[j-1]){
              ar[j] = ar[j-1];              
              j--;
            }
       
            ar[j] = num; 
            printArray(ar);   
          
       }
       
    }
    

    public static void insertionSortPart2(int[] ar)
    {       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
        if(ar.length > 1){
            int index;
            int num;
            
            for(int i=1;i<ar.length;i++){
                insertIntoSorted(ar, i);                
            }
            
        }
    }  
    
    public static void insertionSortNewPart2(int[] ar)
    {       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
        if(ar.length > 1){
            int index;
            int num;
            
            for(int i=1;i<ar.length;i++){
                num = ar[i];
                index = Arrays.binarySearch(ar, 0, i-1,num);
                index = (index * -1)-1;
                                
                if(ar[index] > ar[i]){
                	int j=i;
	                while(j > index){
	                    ar[j] = ar[j-1];
	                    j--;
	                }
	                ar[j] = num;
	                printArray(ar);   
                }else{
                	printArray(ar); 
                }
	                           
            }
            
        }
    } 
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortNewPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
