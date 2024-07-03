import java.util.*;

class RescueBoats {
    public static int rescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        
        int left = 0; 
        int right = people.length - 1;

        int boats = 0; 

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;

            boats++;
        }
        return boats;
    } 
    
}


/**
 * 
 * Optimized approach using the Greedy pattern (Two pointers)

To solve the problem, we can use the greedy pattern and pair people with the lightest and heaviest people available, as long as their combined weight does not exceed the weight limit. If the combined weight exceeds the limit, we can only send one person on that boat. This approach ensures that we use the minimum number of boats to rescue the people.

The steps to implement the approach above are given below:

1. Sort the people array in ascending order so that the lightest person is at the start of the array, and the heaviest person is at the end.

2. Initialize two pointers, left and right. The left pointer points to the lightest person at the start of the array, and the right pointer points to the heaviest person at the end of the array. Next, a variable, boats, is initialized to 0, representing the number of boats used.

3. Iterate over the people array until the left pointer is greater than the right pointer. This means that all people have been rescued. Perform the following steps in each iteration of the loop

	1) Check if both the lightest and heaviest persons can fit in one boat, i.e., people[left] + people[right] is less than or equal to limit. If they can fit, the left pointer is incremented and the right pointer is decremented.

	2) If they cannot fit in one boat, the heaviest person is rescued alone, and the right pointer is decremented.

	3) The boats variable is incremented by 1, representing the number of boats used.

4. Return the minimum number of boats required to rescue all the people.
 */

/** Time Complexity: O(nlogn) - sorting 
 * 
 * Space Complexity: O(n)
 */