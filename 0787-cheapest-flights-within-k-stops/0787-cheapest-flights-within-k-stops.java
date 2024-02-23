class Solution {
    final int INF = 2000000000;
    List<int[]>[] adj;
    public int findCheapestPrice(int n, int[][] flights, int s, int t, int k) {
        k++;
        int[][] d = new int[n][k + 1];
        for(int[] p : d) {
            Arrays.fill(p, INF);
        }
        
        adj = new ArrayList[n];
        Arrays.setAll(adj, e -> new ArrayList<>());
        for(int[] e : flights) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }
        
        d[s][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        while(q.size() > 0) {
            int[] p = q.poll();
            int u = p[0], i = p[1];
            if(i + 1 <= k) {
                for(int[] e : adj[u]) {
                    int nxt = e[0], w = e[1];
                    if(d[u][i] + w < d[nxt][i + 1]) {
                        d[nxt][i + 1] = d[u][i] + w;
                        q.add(new int[]{nxt, i +  1});
                    }
                }
            }
        }
        
        int ans = INF;
        for(int i = 0; i <= k; i++) {
            ans = Math.min(ans, d[t][i]);
        }
        
        return ans == INF ? -1 : ans;
    }
}