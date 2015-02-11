package io.github.asiftasleem.minimumAbsoluteDifference;


public class Solution {

    public static Integer getMinimalAbsoluteDifference(int[] a, int[] b){

    	int i=0, j=0, k=0;
    	int diff = Integer.MAX_VALUE,  cdiff;
    	while (i < a.length && j < b.length)
    	{
    		while (a[i] < b[j]) 
    		{
    			cdiff = b[j] - a[i];
    			cdiff = Math.abs(cdiff);
    			i++;
    			if (cdiff < diff) diff = cdiff;
    			if (i == a.length) return diff;
    		}
    		while (b[j] < a[i])
    		{
    			cdiff = b[j] - a[i];
    			cdiff = Math.abs(cdiff);
    			j++;
    			if (cdiff < diff) diff = cdiff;
    			if (j == b.length) return diff;
    		}
    	}
    	return diff;
    }


    public static void main(String[] args) {
    	
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] ar = new int[n];
//        for(int i=0;i<n;i++){
//            ar[i]=in.nextInt();
//        }
//        in.close();
        int[] ar = {3,5,7,8,11,25};
        int[] ar1 = {10, 12, 15, 30, 35};
        int x = getMinimalAbsoluteDifference(ar, ar1);
        System.out.print(x + " ");
    }
}