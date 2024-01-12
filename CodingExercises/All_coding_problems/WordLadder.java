/** Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.


Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */



class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //Given dict is in list. O(N) just to see if endWord/newWord exists or not.
        //So, we make in set, O(1) Time, O(N) space

        HashSet<String> set = new HashSet<>();
        for(String word: wordList) set.add(word);

        //base case
        if (!set.contains(endWord)) return 0;

        //logic
        int result = Integer.MAX_VALUE; //Final comparison

        //Intuition: we will maintain two queues. One for tracking word, other for distance

        Queue<String> wordQueue = new LinkedList<String>();
        wordQueue.add(beginWord);

        Queue<Integer> distanceQueue = new LinkedList<Integer>();
        distanceQueue.add(1);

        // logic
        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.remove();
            Integer currDist = distanceQueue.remove();

            if (currWord.equals(endWord)) //-> found the endWord, but see if that's the optimal so far'
                result = Math.min(result, currDist);

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c; //change one letter and see next if that exists in wordList

                    String newWord = new String(currCharArr);
                    if (set.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDist + 1);
                        set.remove(newWord);
                    }
                }
            }
        }
        if (result < Integer.MAX_VALUE)
            return result;
        else
            return 0;
    }
}


/** Time: O(N*26 * M) = O(N*M) where N=word.length, M=number of words*/

/** My leetcode submission: https://leetcode.com/problems/word-ladder/solutions/4530913/o-m-n-complexity-in-java */