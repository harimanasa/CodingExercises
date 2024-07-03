public class ZigZagFromString {
    public String convert(String s, int numRows) {
        // Edge case: if there's only one row, return the string as is
        if (numRows == 1) return s;


        StringBuilder[] strings = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){strings[i]=new StringBuilder();}

        int currentRow = 0;
        boolean goingDown = false; /** direction */

        for(int i=0; i<s.length(); i++){
            strings[currentRow].append(s.charAt(i));

            // Change direction at the first and last rows
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row based on the direction
            currentRow += goingDown ? 1 : -1;
            
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : strings){
            result.append(sb);
        }
        return result.toString();
    }
}

/**
 * O(n) time and O(n) space
 * 
 * 
 */