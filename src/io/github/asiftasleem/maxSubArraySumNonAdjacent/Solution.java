/**
 * 
 */
package io.github.asiftasleem.maxSubArraySumNonAdjacent;

/**
 * @author mtasleem
 *
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static Integer[] mem;
    static int maxSubsetSum(int[] arr) {
        Solution.mem = new Integer[arr.length];
        int result = maxSum(arr, arr.length-1);
        return result;
    }
    
    static int maxSum(int[] arr, int i){
        if(i==0)
            return arr[0];
        if(i==1)
            return Math.max(arr[0], arr[1]);
        if(mem[i]!=null)
            return mem[i];
        else{
            mem[i] = Math.max(maxSum(arr, i-1),arr[i] + maxSum(arr, i-2));
            return mem[i];
        }
        
    }
    
    static int maxSumOp(int[] arr){
        int prevOne=0, prevTwo=0, res=0;
        for(int i=0; i<arr.length; i++){
            if(i==0)
                res = arr[0];
            if(i==1)
                res = Math.max(arr[0], arr[1]);
            else
                res = Math.max(prevOne,arr[i] + prevTwo);
            
            prevTwo = prevOne;
            prevOne = res;
        }
        
        return res;
        
    }
    
    /**
     * Fast Memoization solution.
     */
    private static int maxSum(int arr[]) {
        Long excl = 0L;
        Long incl = new Long(arr[0]);
        for (int i = 1; i < arr.length; i++) {
        	Long temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }
        return incl.intValue();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSum(arr);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
        System.out.println(res);

        scanner.close();
    }
}
