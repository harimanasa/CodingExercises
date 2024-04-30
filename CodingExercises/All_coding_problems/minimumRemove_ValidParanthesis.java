class Solution {

    public static String minRemoveToMakeValid(String s) {
        Stack<int[]> stack = new Stack<>();
        char[] sArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);

            if (!stack.isEmpty() && stack.peek()[0] == '(' && val == ')') {
                stack.pop();
            } else if (val == '(' || val == ')') {
                stack.push(new int[]{val, i});
            }
        }

        while (!stack.isEmpty()) {
            sArray[stack.pop()[1]] = ' ';
        }

        StringBuilder result = new StringBuilder();
        for (char c : sArray) {
            if (c != ' ') {
                result.append(c);
            }
        }

        return result.toString();
    }
}