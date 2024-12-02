/**
 * 
 * To recap, the solution to this problem can be divided into the following five parts:

Divide the array into two halves.

Check if the first half is sorted, and if it is, do the following.

    Check if the target lies in this range, and if it does, perform a binary search on this half for the target value.

    If the target does not lie in this range, move to the second half of the array.

If the first half is not sorted, check if the target lies in the second half.

    If the target lies in this half, perform a binary search on this half for the target value.

    If the target does not lie in the second half, examine the first half.

If the target value is not found at the end of this process, we return -1
 */

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


