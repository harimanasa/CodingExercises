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
        for (int i = 0; i < n; i++) {
            // Get the value of the current Roman numeral
            int value = map.get(s.charAt(i));

            // Check if the current numeral is smaller than the next one
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                result -= value; // Subtract the value
            } else {
                result += value; // Add the value
            }


        }
        return result;
    }

}