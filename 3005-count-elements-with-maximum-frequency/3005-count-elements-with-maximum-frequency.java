class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int max = 0;
        for(int i : nums) {
            count[i]++;
            max = Math.max(max, count[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }
}