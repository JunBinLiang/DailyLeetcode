class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stk.size() > 0 && c == stk.peek()) stk.pop();
            else stk.push(c);
        }
        StringBuilder ans = new StringBuilder();
        while(stk.size() > 0) ans.append(stk.pop());
        return ans.reverse().toString();
    }
}