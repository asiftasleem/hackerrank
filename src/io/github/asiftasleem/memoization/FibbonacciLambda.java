/**
 * 
 */
package io.github.asiftasleem.memoization;

import java.util.HashMap;

/**
 * @author mtasleem
 *
 */
public class FibbonacciLambda {
	
	private static HashMap<Integer, Long> memos = new HashMap<>();
	static {
		memos.put(0, 0L);
		memos.put(1, 1L);
		
	}

	
	public static long calculate(int n) {
		return memos.computeIfAbsent(n, x -> Math.addExact(calculate(x-1), calculate(x-2)));
	}

}
