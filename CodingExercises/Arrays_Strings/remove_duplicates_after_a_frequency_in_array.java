/** Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums. */


class Solution {
    public int removeDuplicates(int[] nums) {
        //initialization
        int reader = 0, writer = 0;
        int val = Integer.MIN_VALUE; //Because we're comparing, we need to compare with a safe unproblematic value


        while(reader < nums.length){
            if(nums[reader] == val) reader++; //Reader continues no matter what
            else {
                nums[writer] = nums[reader]; //Writer only commits once it finds a good value
                val = nums[writer]; //update the val to the new value found 
                reader++; //Reader continues
                writer++; //Writer continues
            }
        }
        return writer;
    }
}