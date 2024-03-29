/** https://leetcode.com/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150 */

/** Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not). */

/** Solution: Intuition: Two pointers */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1=0, p2=0;

        //base case:
        if(s==null || t==null || s.length()> t.length()) return false;

        //logic
        while(p1<s.length() && p2<t.length()){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++; p2++;
            } else{
                p2++;
            }
        }

        return p1==s.length();
    }
}