class Solution {
    public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3)
      throw new IllegalArgumentException();

    Arrays.sort(nums);

    int smallestDifference = Integer.MAX_VALUE;
    
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (target == sum) 
          return target;

        int targetDiff = target - sum;

        if (Math.abs(targetDiff) < Math.abs(smallestDifference))
          smallestDifference = targetDiff; // save the closest and the biggest difference

        if (target > sum)
          left++; // we need a triplet with a bigger sum
        else
          right--; // we need a triplet with a smaller sum
      }

    }
    return target - smallestDifference;  
    }
}