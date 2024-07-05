public class RotatedSortedArray {
        public int search(int[] nums, int target) {
            
            int low = 0, high = nums.length - 1;
            
            while(low<=high){
                int mid = low + (high-low)/2;
                if(nums[mid] == target) return mid;
                
                if(nums[low] <= nums[mid]){ //left sub array sorted
                    if(nums[low] <= target && target <= nums[mid]){ //target can be in left array
                        high = mid - 1;
                    } else { //target can be in right array
                        low = mid + 1;
                    }
                    
                } else { //right subarray sorted
                    if(nums[mid] <= target && target <= nums[high]){ //target can be in right array
                        low = mid + 1;
                    } else { //target can be in left array
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
}

/**
 * Solution summary

To recap, the solution to this problem can be divided into the following five parts:

1. Divide the array into two halves.

2. Check if the first half is sorted, and if it is, do the following.

	1) Check if the target lies in this range, and if it does, perform a binary search on this half for the target value.

	2) If the target does not lie in this range, move to the second half of the array.

3. If the first half is not sorted, check if the target lies in the second half.

	1) If the target lies in this half, perform a binary search on this half for the target value.

	2) If the target does not lie in the second half, examine the first half.

4. If the target value is not found at the end of this process, we return -1.
 * 
 * 

 Time complexity
The time complexity of both approaches is O(logn) since we divide the array into two halves at each step.

Space complexity
The space complexity of the iterative solution is O(1) since no new data structure is being created.

The space complexity of the recursive solution is O(logn) where n is the number of elements present in the array and (log n) is the maximum number of recursive calls needed to find the target.
 * 
 */