/*

https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0, p2 = 0;
        int m = word1.length(), n = word2.length();
        StringBuilder sb = new StringBuilder();
        while (p1<m && p2<n) {
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
        }
        if(p1<m) sb.append(word1.substring(p1));
        if(p2<n) sb.append(word2.substring(p2));

        return sb.toString();
    }
}
