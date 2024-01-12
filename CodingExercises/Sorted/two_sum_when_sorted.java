/* Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space. */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low=0, high=numbers.length-1;

        while(low<high){
            int low_number = numbers[low];
            int high_number = numbers[high];
            if(target>(low_number+high_number)) low++;
            else if(target<(low_number+high_number)) high--;
            else 
                return new int[]{low+1, high+1};
        }
        return new int[2];
    }
}

/** Time: O(N), Space: O(1) */