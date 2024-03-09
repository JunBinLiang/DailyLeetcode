class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums1) set.add(x);
        for(int x : nums2) {
            if(set.contains(x)) {
                return x;
            }
        }
        return -1;
    }
}