class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int x : squares) {
                if(i >= x && dp[i - x] != -1) {
                    if(dp[i] == -1) dp[i] = dp[i - x] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - x] + 1);
                }
            }
        }
        
        return dp[n];
    }
}