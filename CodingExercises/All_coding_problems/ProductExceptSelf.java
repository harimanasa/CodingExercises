import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        //validation
        if(nums==null || nums.length==0) return nums;
        
        //logic
        int n = nums.length;
        int[] output = new int[n];
        Arrays.fill(output, 1);
        
        int prev=1;
        for(int i=0; i<n; i++){
            output[i] *= prev;
            prev *= nums[i];
        }
            
        int next=1;
        for(int i=n-1; i>=0; i--){
            output[i] *= next;
            next *= nums[i];
        }

        
        return output;
    }
}


/**
 * 
 * The solution can be summarized in the following steps:

Create a list with the same length as the input list, initialized with 1s.

Keep track of products on the left and right sides of the current element.

Use two pointers—one starting from the beginning and the other from the end of the list.

Multiply and update values in the output array based on accumulated products and current element values.

Move the pointers toward each other to process the entire list.

Time complexity
The time complexity of this solution is O(n), since both the pointers simultaneously traverse the length of the array once.

Space complexity
The space complexity of this solution is O(1), since it doesn’t use any additional array for computations but only constant additional space.
 */