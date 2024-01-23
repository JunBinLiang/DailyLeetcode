class Solution {
    public int maxLength(List<String> arr) {
        
        int[] bits = new int[arr.size()];
        int res = 0;
        for(int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            int bit = 0;
            for(int j = 0; j < s.length(); j++) {
                int c = s.charAt(j);
                if((bit & (1 << c)) > 0) {
                    bit = -1;
                    break;
                }
                bit |= (1 << c);
            }
            bits[i] = bit;
        }
        
        for(int s = 0; s < (1 << arr.size()); s++) {
            int bit = 0, sum = 0;
            boolean ok = true;
            for(int i = 0; i < arr.size(); i++) {
                if((s & (1 << i)) > 0) {
                    if(bits[i] == -1) {
                        ok = false;
                        break;
                    }
                    if((bit & bits[i]) > 0) {
                        ok = false;
                        break;
                    }
                    bit |= (bits[i]);
                    sum += arr.get(i).length();
                }
            }
            if(ok) res = Math.max(res, sum);
        }
        return res;
    }
}