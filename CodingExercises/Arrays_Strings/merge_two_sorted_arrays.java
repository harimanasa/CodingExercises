/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1; //start from end of first list
        int p2 = n-1; //start from end of second list
        int endOfmerge = m+n-1; //Intution: Let's merge from the end

        /** we cannot put (p2>=0 && p1>=0) here */
        /** because you cannot merge even when one of the lists is still not exhausted */
        while(p2>=0){ //since nums2 list is shorter, we want to first exhaust it
            if(p1>=0 && nums1[p1]>nums2[p2]){ //making sure p1 is not already exhausted
                nums1[endOfmerge--] = nums1[p1--];
            } else{ 
                nums1[endOfmerge--] = nums2[p2--];
            }
        }
    }
}