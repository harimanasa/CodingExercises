class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> strMap = new HashMap<>();
        HashMap<String, Character> chMap = new HashMap<>();
        
        char chs[] = pattern.toCharArray();
        String strs[] = s.split(" ");
        
        if(chs.length!=strs.length) return false;
        
        int i = 0; 
        while(i<chs.length){
            char ch = chs[i];
            String str = strs[i];
            
            if(strMap.containsKey(ch)){//case 1
                if(!strMap.get(ch).equals(str)) return false;
            }
            if(chMap.containsKey(str)){//case 2
                if(chMap.get(str)!=ch) return false;
            }
            if(!strMap.containsKey(ch) && !chMap.containsKey(str)){
                strMap.put(ch, str);
                chMap.put(str, ch);
            }
            
            i++;
        }
        return true;
    }
}