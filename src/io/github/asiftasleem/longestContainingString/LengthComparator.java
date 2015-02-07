/**
 * 
 */
package io.github.asiftasleem.longestContainingString;

import java.util.Comparator;

/**
 * @author Asif
 *
 */
public class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		// TODO Auto-generated method stub
		if(str1.length() < str2.length())
			return 1;
		else if(str1.length() > str2.length())
			return -1;
		else
			return 0;
	}

}
