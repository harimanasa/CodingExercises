class MostWater{

public static int containerWithMostWater(int[] height) {
        
    int maxArea = 0;
    int start = 0;
    int end = height.length - 1;

    while (start < end) {
  
        int width = end - start;      
        maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * width);

        if (height[start] <= height[end]) {
            start++;
        }
        else {
            end--;
        }
    }

    return maxArea;
    }
}

/**
 * 
 * Solution summary
Initialize two pointers, start and end, at the beginning and end of the input array, respectively.

Iterate through the array until the pointers converge.

In each iteration, perform the following steps:

Calculate the distance, width, between the two vertical lines pointed by the start and end pointers.

Multiply the height of the shorter vertical line with the width to calculate the area. Also, update the value of the maximum area.

Move the pointer pointing to the shorter vertical line inward by one step.

After iterating through the array, return the maximum area calculated.

Time complexity
The time complexity of this solution is  O(N)
 is the length of the input array since we have visited the elements of the input array only once.

Space complexity
The space complexity of this solution is O(1), since we have only used constant space.
 */