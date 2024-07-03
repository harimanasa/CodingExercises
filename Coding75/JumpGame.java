import java.util.*;

class JumpGame {
    public static boolean jumpGame(int[] nums) {
        int targetNumIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (targetNumIndex <= (i + nums[i])) {
                targetNumIndex = i;
            }
        }
        return targetNumIndex == 0;
    }
}

/** 
 * Naive approach : Backtracking | time complexity of the backtracking approach will be exponential.
 * 
Optimal: Greedy | Alternatively, an optimized approach to solve this problem is using the greedy technique by traversing our array backward. We check the elements one by one from the last element of our array. We keep track of the elements that can reach the ending point directly and verify if there are any possible paths to these indexes. We’re “greedy” because we always pick the nearest preceding element that provides a path to the ending point. We can afford to be “greedy”, since there is no danger of overshooting the target. The value at each index specifies the longest jump we can make and doesn’t restrict us from making a smaller jump if that suits us better.


 * 
 */


/**
 * Solution summary
Set the last index of the array as the target index.
Traverse the array backward and verify if we can reach the target index from any of the previous indexes.

If we can reach it, we update the target index with the index that allows us to jump to the target index.

We repeat this process until we’ve traversed the entire array.

Return TRUE if, through this process, we can reach the first index of the array. Otherwise, return FALSE.


Time complexity
The time complexity of the above solution is O(n), since we traverse the array only once, where n is the number of elements in the array.

Space complexity
The space complexity of the above solution is O(1), because we do not use any extra space.
 */