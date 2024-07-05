import java.util.HashMap;

class PalindromePermutation {
  
    public static boolean permutePalindrome(String st) {
      
      HashMap < Character,Integer > frequencies = new HashMap < Character,Integer > ();
      for (int i = 0; i < st.length(); i++) {
        if (frequencies.containsKey(st.charAt(i))) {
          frequencies.put(st.charAt(i), frequencies.get(st.charAt(i)) + 1);
        }
        else {
          frequencies.put(st.charAt(i), 1);
        }
      }
    
      int count = 0;
  
      for (Character ch: frequencies.keySet()) {
        if (frequencies.get(ch) % 2 != 0) {
          count += 1;
        }
      }
  
      if (count <= 1) {
        return true;
      }
      else {
        return false;
      }
    }
}