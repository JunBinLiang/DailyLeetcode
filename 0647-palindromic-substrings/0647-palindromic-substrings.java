class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while(l >= 0 && r < s.length()) {
                if(s.charAt(l--) != s.charAt(r++)) break;
                ans++;
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            int l = i, r = i + 1;
            while(l >= 0 && r < s.length()) {
                if(s.charAt(l--) != s.charAt(r++)) break;
                ans++;
            }
        }
        
        return ans;
    }
}