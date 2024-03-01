class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char[] a = new char[n];
        Arrays.fill(a, '0');
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                a[j++] = '1';
            }
        }
        
        if(j != n) {
            a[n - 1] = '1';
            a[j - 1] = '0';
        }
        
        return new String(a);
    }
}