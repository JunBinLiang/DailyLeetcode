class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, 1 + map.get(c));
            }
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((c1, c2) -> {
            return map.get(c2) - map.get(c1); 
        });
        for(char c : map.keySet()) {
            pq.add(c);
        }
        
        StringBuilder ans = new StringBuilder();
        while(pq.size() > 0) {
            char c = pq.poll();
            int count = map.get(c);
            for(int i = 0; i < count; i++) {
                ans.append(c);
            }
        }
    
        return ans.toString();        
    }
}