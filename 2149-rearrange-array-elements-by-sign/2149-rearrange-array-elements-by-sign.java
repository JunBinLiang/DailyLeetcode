class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(nums[i] < 0) {
                neg.add(nums[i]);
            } else {
                pos.add(nums[i]);
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                nums[i] = pos.get(i / 2);        
            } else {
                nums[i] = neg.get(i / 2);        
            }
        }
        
        return nums;
        
    }
    
    
}