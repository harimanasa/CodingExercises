/**
 * 
 * Algorithm
Initialize an empty list ans to store the rearranged characters.

Create a priority queue pq using a heap data structure. 
Each element in pq is a tuple containing the count of a character 
and the character itself. The priority queue is ordered in a way such that 
elements with higher counts have higher priority.

Pop the element with the highest priority from pq. 
Assign its count and character to count_first and char_first respectively.

If ans is empty or the current character char_first is different 
from the last character in ans, append char_first to ans. 
If the count of char_first is not zero, update its count by decreasing it by one. 
If the updated count is larger than zero, push it back to pq. 
Continue to the next iteration.
Otherwise, if char_first is the same as the last character in ans, 
it means we need to choose a different character.
If pq is empty, return an empty string as it is impossible to rearrange the characters.
Pop the next element from pq, 
assigning its count and character to count_second and char_second respectively. 

Append char_second to ans.
If the count of char_second is not zero, update its count by decreasing it by one. 

If the updated count is larger than zero, push it back to pq.
Finally, push the original char_first back to pq.
Return the rearranged characters as a string by joining the elements in ans.
 */


class Solution {
    public String reorganizeString(String s) {
        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Max heap ordered by character counts
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.offer(new int[] {i + 'a', charCounts[i]});
            }
        }
            
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                
                var second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                
                pq.offer(first);
            }
        }
        
        return sb.toString();
    }
}