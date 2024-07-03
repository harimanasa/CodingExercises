import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0, n = s.length();
        for (int i = 0; i < n; i++) { //Manasa: this loop is till n
            // Get the value of the current Roman numeral
            int value = map.get(s.charAt(i));

            // Check if the current numeral is smaller than the next one
            /* Manasa: if it is n-1 is important, otherwise 
             it will check n-1 value to out of bound */
             
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                result -= value; // Subtract the value
            } else {
                result += value; // Add the value
            }


        }
        return result;
    }

    /*
     * public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("XLII")); // 42
        System.out.println(solution.romanToInt("CXCIV")); // 194
        System.out.println(solution.romanToInt("MMMCDXLIV")); // 3444
    }
     */

}