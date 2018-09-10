# Almost Sorted
Given an array of integers, can you sort an array in ascending order using only one of the following operations one time?

Swap two elements.
Reverse one sub-segment.
If either one would work, choose swap over reverse. For instance, given an array  we can swap the  and , or reverse them. We choose swap.

### Input Format

The first line contains a single integer , the size of . 
The next line contains  space-separated integers  where .

### Constraints
2 <= n <= 100,000
0 <= arr[i] <= 100,000
All arr[i] are distinct


### Output Format

If the array is already sorted, output yes on the first line. You do not need to output anything else.

If you can sort this array using one single operation (from the two permitted operations) then output yes on the first line and then:

a. If you can sort the array by swapping  and , output swap l r in the second line.  and  are the indices of the elements to be swapped, assuming that the array is indexed from  to .

b. Else if it is possible to sort the array by reversing the segment , output reverse l r in the second line.  and  are the indices of the first and last elements of the subsequence to be reversed, assuming that the array is indexed from  to .

 represents the sub-sequence of the array, beginning at index  and ending at index , both inclusive.

If an array can be sorted by either swapping or reversing, stick to the swap-based method.

If you cannot sort the array in either of the above ways, output no in the first line.

### Sample Input 1

2  
4 2  
### Sample Output 1

yes  
swap 1 2
Explanation 1

You can either swap(1, 2) or reverse(1, 2). You prefer swap.

### Sample Input 2

3
3 1 2

### Sample Output 2

no
Explanation 2

It is impossible to sort by one single operation.

### Sample Input 3

6
1 5 4 3 2 6

### Sample Output 3

yes
reverse 2 5
Explanation 3

You can reverse the sub-array d[2...5] = "5 4 3 2", then the array becomes sorted.