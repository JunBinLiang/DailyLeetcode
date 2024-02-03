class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        
        for(int[] p : dp) {
            Arrays.fill(p, -1);
        }
        
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            int curMax = 0;
            for(int j = i; j >= Math.max(1, i - k + 1); j--) {
                curMax = Math.max(curMax, nums[j - 1]);
                for(int x = 1; x <= n; x++) {
                    if(dp[j - 1][x - 1] != -1) {
                        dp[i][x] = Math.max(dp[i][x], dp[j - 1][x - 1] + curMax * (i - j + 1));
                    }
                }
            }
        }
        
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        return ans;
    }
}