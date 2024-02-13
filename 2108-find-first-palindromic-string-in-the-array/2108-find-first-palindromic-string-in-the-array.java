class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words) {
            if((new StringBuilder(s)).reverse().toString().equals(s)) {
                return s;
            }
        }
        return "";
    }
}