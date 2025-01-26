class Solution {
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