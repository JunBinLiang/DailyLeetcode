class Solution {
    public String minWindow(String s, String t) {
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        int n = s.length();
        for(int i = 0; i < t.length(); i++) {
            count1[t.charAt(i)]++;
        }
        
        int o = 0;
        for(int i = 0; i < 256; i++) {
            if(count2[i] >= count1[i]) {
                o++;
            }
        }
        
        int L = -1, len = n * 2;
        for(int i = 0, j = 0; i < n; i++) {
            int c = s.charAt(i);
            count2[c]++;
            if(count2[c] - count1[c] == 0) {
                o++;
            }

            while(o == 256) {
                if(i - j + 1 < len) {
                    len = i - j + 1;
                    L = j;
                }
                if(count1[s.charAt(j)] == count2[s.charAt(j)]) o--;
                count2[s.charAt(j)]--;
                j++;
            }
        }
        
        return L == -1 ? "" : s.substring(L, L + len);
    }
}