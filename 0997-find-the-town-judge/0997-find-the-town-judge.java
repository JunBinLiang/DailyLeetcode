class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] deg = new int[n + 1];
        boolean[] has = new boolean[n + 1];
        for(int[] e : trust) {
            deg[e[1]]++;
            has[e[0]] = true;
        }
        
        int ans = -1;
        for(int i = 1; i <= n; i++) {
            if(deg[i] == n - 1 && !has[i]) {
                if(ans != -1) return -1;
                ans = i;
            }
        }
        return ans;
    }
}