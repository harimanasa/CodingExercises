/** Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote. **/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //base case:
        if(ransomNote==null || magazine == null || ransomNote.length()>magazine.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: magazine.toCharArray()){
            if(!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch)+1);
        }

        for(char ch: ransomNote.toCharArray()){
            if(!map.containsKey(ch)) return false;
            else {
                int char_count = map.get(ch);
                if(char_count==1) map.remove(ch);
                else map.put(ch, char_count-1);
            }
        }

        return true;
    }
}

//OR

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }
}