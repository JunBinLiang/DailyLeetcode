class Solution {
    public boolean isPowerOfTwo(int n) {
        return Long.bitCount(n) == 1;
    }
}