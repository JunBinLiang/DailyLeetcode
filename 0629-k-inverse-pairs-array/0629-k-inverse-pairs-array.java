class Solution {
    final int MOD = 1000000000 + 7;
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 1;
        for(int j = 1; j <= k; j++) {
            dp[0][j] += dp[0][j - 1];
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int l = Math.max(0, j - i);
                dp[i][j] = dp[i - 1][j] - (l == 0 ? 0 : dp[i - 1][l - 1]);
                dp[i][j] += MOD;
                dp[i][j] %= MOD;
            }
            
            for(int j = 1; j <= k; j++) {
                dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }
        
        return (dp[n - 1][k] - (k == 0 ? 0 : dp[n - 1][k - 1]) + MOD) % MOD;
    }
}