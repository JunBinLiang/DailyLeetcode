class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int ans = 0;
        
        for(int ur = 0; ur < n; ur++) {
            int[] sums = new int[m];
            int[] p = new int[m];
            for(int dr = ur; dr < n; dr++) {
                Map<Integer, Integer> map = new HashMap<>();    
                for(int c = 0; c < m; c++) {
                    sums[c] += mat[dr][c];
                    p[c] = sums[c];
                    if(c > 0) p[c] += p[c - 1];
                    if(p[c] == t) ans++;
                    if(map.containsKey(p[c] - t)) {
                        ans += map.get(p[c] - t);
                    } 
                    if(!map.containsKey(p[c])) {
                        map.put(p[c], 0);
                    }
                    map.put(p[c], map.get(p[c]) + 1);
                }
            }
        }
        
        return ans;
    }
}