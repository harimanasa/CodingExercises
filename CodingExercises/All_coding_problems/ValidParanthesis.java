class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if (map.containsKey(ch)){ //if encountered closing bracket, check stack empty or not and check matching
                if(stack.isEmpty() || stack.pop() != map.get(ch)) return false;
            }
            else //if encountered opening bracket, push in stack
                stack.push(ch);
        }
        return stack.isEmpty();
    }
}