/**
 * Initialize an empty deque data structure.

2. Iterate through the first w elements in the input array, 
performing cleanup operations on the deque 
to maintain a decreasing order of values.

3. Store the maximum value of the initial window.

4. Slide the window through the array, 
updating the deque and storing maximum values for each window.
 * 
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
	
    //base case
    if (nums.length == 0) return new int[0];
	
    //init
    Deque<Integer> d = new ArrayDeque<>();
	int[] result = new int[nums.length - k + 1];

    //logic
	for (int i = 0; i < nums.length; i++) {
		int num = nums[i];

		//discard values lower than current
		while (!d.isEmpty() && nums[d.peekLast()] < num) {
			d.removeLast();
		}
        
		//discard right-most index of previous window
		if (!d.isEmpty() && d.peekFirst() == i - k) {
			d.pop();
		}

		//add current
		d.add(i);

		//skip over the first window
		if (i < k - 1) {
			continue;
		}

		//head of d contains the max value over the window
		result[i - k + 1] = nums[d.peekFirst()];
	}
	return result;
}
}