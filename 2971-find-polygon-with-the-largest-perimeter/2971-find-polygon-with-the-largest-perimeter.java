class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = -1;
        
        long sum = 0;
        for(int i = 0; i < n; i++) {
            if(i >= 2 && nums[i] < sum) {
                ans = Math.max(ans, sum + nums[i]);
            }
            sum += nums[i];
        }
        return ans;
    }
}