//Link: https://www.educative.io/module/page/y8E3zVtAPZBkZzKp0/10370001/5354142048190464/4589095629881344

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int current : nums2) {
            while (!stack.empty() && current > stack.peek()) {
                map.put(stack.pop(), current);
            }
            
            stack.push(current);
        }

        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
