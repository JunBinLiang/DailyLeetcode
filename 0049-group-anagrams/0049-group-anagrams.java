class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char sortArray[] = str.toCharArray();
            Arrays.sort(sortArray);
            String sortStr = new String(sortArray);
            
            if(!map.containsKey(sortStr)) {
                map.put(sortStr, new ArrayList<>());
            }
            map.get(sortStr).add(str);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}