class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[256];
        int n = s.length(), diff = 0;
        for(int i = 0; i < t.length(); i++) {
            diff += (count[t.charAt(i)] == 0) ? 1 : 0;
            count[t.charAt(i)]++;
        }
        
        
        int L = -1, len = n * 2;
        for(int i = 0, j = 0; i < n; i++) {
            int c = s.charAt(i);
            count[c]--;
            diff -= (count[c] == 0) ? 1 : 0;
            while(diff == 0) {
                if(i - j + 1 < len) {
                    len = i - j + 1;
                    L = j;
                }
                count[s.charAt(j)]++;
                diff += (count[s.charAt(j)] == 1) ? 1 : 0;
                j++;
            }
        }
        
        return L == -1 ? "" : s.substring(L, L + len);
    }
}