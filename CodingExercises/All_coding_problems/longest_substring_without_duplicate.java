class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(right<s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(map.get(c), left); //Check if map.get(c) it is outside the window -- left of the outside
            } map.put(c, right+1);
            max = Math.max(max, right-left+1);
            right++;
        }
        return max; 
    }
}