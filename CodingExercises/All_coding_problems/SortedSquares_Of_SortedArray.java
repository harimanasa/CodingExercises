/**
 * I/P = [-2, -1, 0, 2, 3]
 * 
 * O/P = [0, 1, 4, 4, 9]
 * 
 * Pattern: Two pointers, left and right
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        
        int left = 0, right = n-1;
        int outputIndex = n-1;

        while(left<=right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];

            if(leftSquare>rightSquare){
                output[outputIndex--] = leftSquare;
                left++;
            } else{
                output[outputIndex--] = rightSquare;
                right--;
            }
        }

        return output;
    }
}