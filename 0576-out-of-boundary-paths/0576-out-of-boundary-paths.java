class Solution {
    final int MOD = 1000000007;
    int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m + 1][n + 1][maxMove + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                for(int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(startRow, startColumn, maxMove, m, n);
    }
    
    public int dfs(int i, int j, int move, int n, int m) {
        if(i < 0 || j < 0 || i >= n || j >= m) {
            return 1;
        }
        if(move == 0) {
            return 0;
        }
        
        if(dp[i][j][move] != -1) {
            return dp[i][j][move];
        }
        
        int res = 0;
        res += dfs(i + 1, j, move - 1, n, m);
        res %= MOD;
        res += dfs(i - 1, j, move - 1, n, m);
        res %= MOD;
        res += dfs(i, j + 1, move - 1, n, m);
        res %= MOD;
        res += dfs(i, j - 1, move - 1, n, m);
        res %= MOD;
        
        return dp[i][j][move] = res;
    }
}