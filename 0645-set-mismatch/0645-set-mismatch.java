class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(nums[i] - 1 != i) {
                return new int[]{nums[i], i + 1};        
            }
        }
        return null;
    }
}