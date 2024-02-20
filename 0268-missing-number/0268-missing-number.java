class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i && nums[i] < nums.length) {
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}