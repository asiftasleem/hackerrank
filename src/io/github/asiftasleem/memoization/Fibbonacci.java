/**
 * 
 */
package io.github.asiftasleem.memoization;

/**
 * @author mtasleem
 *
 */
public class Fibbonacci {
	
	int[] memos;

	/**
	 * 
	 */
	public Fibbonacci(int n) {
		memos = new int[n+1];
	}

	
	public int calculate(int n) {
		if(n <= 1)
			return n;
		else if(memos[n]!=0) {
			System.out.println("Returning stored value for :: " + n);
			return memos[n];
		}else {
			int fibValue = calculate(n-1) + calculate(n-2);
			memos[n] = fibValue;
			return fibValue;
		}
	}

}
