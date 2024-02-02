class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i = 1; i < 10; i++) {
            dfs(low, high, i);
        }
        Collections.sort(ans);
        return ans;
    }
    
    public void dfs(int lo, int hi, int cur) {
        if(cur >= lo && cur <= hi) {
            ans.add(cur);
        }
        
        if(cur > hi) {
            return;
        }
        
        int last = cur % 10;
        if(last + 1 < 10) {
            dfs(lo, hi, cur * 10 + last + 1);
        }
    }
}