class Solution {
    public static int binarySearch(List<Integer> nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums.get(mid) == target) return mid;
        if (nums.get(start) <= nums.get(mid)) {
            if (nums.get(start) <= target && target < nums.get(mid)) {
                return binarySearch(nums, start, mid - 1, target);
            }
            return binarySearch(nums, mid + 1, end, target);
        } else {
            if (nums.get(mid) < target && target <= nums.get(end)) {
                return binarySearch(nums, mid + 1, end, target);
            }
            return binarySearch(nums, start, mid - 1, target);
        }
    }

    public static int binarySearchRotated(List<Integer> nums, int target) {
        return binarySearch(nums, 0, nums.size() - 1, target);
    }