class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            Integer count = map.get(x);
            if(count == null) map.put(x, 1);
            else map.put(x, 1 + count);
        }
        
        List<Integer> frequencyCount = new ArrayList<>();
        for(Integer key : map.keySet()) {
            frequencyCount.add(map.get(key));
        }
        
        Collections.sort(frequencyCount);
        int ans = frequencyCount.size();
        
        for(int i = 0; i < frequencyCount.size(); i++) {
            if(k >= frequencyCount.get(i)) {
                k -= frequencyCount.get(i);
                ans--;
            }
        }
        
        return ans;
    }
}