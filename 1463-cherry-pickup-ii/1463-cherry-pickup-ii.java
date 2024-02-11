class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m]; // (row, column1, column2)
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                for(int k = 0; k < dp[0][0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        
        int ans = grid[0][0] + grid[0][m - 1];
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        
        for(int r = 1; r < n; r++) {
            for(int c1 = 0; c1 < m; c1++) {
                for(int c2 = 0; c2 < m; c2++) {
                    for(int i = -1; i <= 1; i++) {
                        for(int j = -1; j <= 1; j++) {
                            int cc1 = c1 + i, cc2 = c2 + j;
                            if(cc1 >= 0 && cc1 < m && cc2 >= 0 && cc2 < m && dp[r - 1][cc1][cc2] != -1) {
                                dp[r][c1][c2] = Math.max(dp[r][c1][c2], dp[r - 1][cc1][cc2] + (c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2]));
                                ans = Math.max(ans, dp[r][c1][c2]);
                            }
                        }
                    }
                    
                }
            }
        }
        
        return ans;
    }
}