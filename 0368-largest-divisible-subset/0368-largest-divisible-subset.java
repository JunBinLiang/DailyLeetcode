class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] p = new int[n];
        int max = -1, index = -1;
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            p[i] = -1;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    p[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(index != -1) {
            ans.add(nums[index]);
            index = p[index];
        }
        return ans;
    }
}