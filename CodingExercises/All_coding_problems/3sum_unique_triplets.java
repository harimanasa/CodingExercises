//Unique:
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //if(nums)        
        List<List<Integer>> result = new ArrayList<>();
        //edge cases
        int n=nums.length;
        if(n<3){ return result;}
        
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){ //-2 important for first number to be valid
            if ((i > 0) && (nums[i - 1] == nums[i])) continue; //avoid duplicate in first number
            
            int low = i+1, high = n-1;
            
            while(low<high)
            {
            int sum = nums[i] + nums[low] + nums[high];

            if(sum==0){
                result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;

                while(low<high && nums[low]==nums[low-1]) { low++; } //avoid duplicate in second number
                while(low<high && nums[high]==nums[high+1]) { high--; } //avoid duplicate in third number
            }
            
            else if(sum<0){
                low++;
            }
            else{
                high--;
            }
        }
        }
        return result;
    }
}