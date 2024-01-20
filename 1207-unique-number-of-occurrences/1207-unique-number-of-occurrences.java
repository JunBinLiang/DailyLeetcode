class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            int j = i;
            while(j < arr.length && arr[j] == arr[i]) {
                j++;
            }
            if(set.contains(j - i)) {
                return false;
            }
            set.add(j - i);
            i = j - 1;
        }
        return true;
    }
}