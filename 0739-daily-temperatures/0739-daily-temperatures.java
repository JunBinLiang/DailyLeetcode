class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(stk.size() > 0 && temperatures[i] > temperatures[stk.peek()]) {
                ans[stk.peek()] = i - stk.pop(); 
            }
            stk.push(i);
        }
        return ans;
    }
}