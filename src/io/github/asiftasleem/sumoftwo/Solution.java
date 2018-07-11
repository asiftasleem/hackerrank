package io.github.asiftasleem.sumoftwo;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int[] index = twoSum(nums, 6);
		System.out.println(String.format("Sum of numbers at indexes %d & %d = %d", index[0], index[1], 6));
		
	}
	
    public static int[] twoSums(int[] nums, int target) {
        boolean found = false;
        int i = 0;
        int j = 0;
        while(i<nums.length){
            j=i+1;
            while(j<nums.length){
                if((nums[i]+nums[j]) == target){
                    found=true;
                    break;
                }else{
                    j++;
                }     
            }
            if(found)
                break;
            else
                i++;
                
        }
        
        if(found)
            return new int[] {i,j};
        return new int[] {-1, -1};
    }
    
    
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{-1,-1};
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
            	result[0] = map.get(target - numbers[i]);
            	result[1] = i;
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

}


