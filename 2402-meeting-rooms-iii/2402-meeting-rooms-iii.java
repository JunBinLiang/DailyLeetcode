class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });
        
        int[] count = new int[n];
        PriorityQueue<long[]> running = new PriorityQueue<>((x, y) -> {
            if(x[1] == y[1]) {
                return Long.compare(x[0], y[0]);
            }
            return Long.compare(x[1], y[1]);
        });
        PriorityQueue<long[]> free = new PriorityQueue<>((x, y) -> {
            return Long.compare(x[0], y[0]);
        }); 
        for(int i = 0; i < n; i++) free.add(new long[]{i, -1});
        
        for(int[] meeting : meetings) {
            int s = meeting[0], e = meeting[1];
            while(running.size() > 0 && running.peek()[1] <= s) {
                free.add(running.poll());
            }
            if(free.size() > 0) {
                free.peek()[1] = e;
                count[(int)(free.peek()[0])]++;
                running.add(free.poll());
            } else {
                long[] p = running.poll();
                p[1] += (e - s);
                count[(int)(p[0])]++;
                running.add(p);
            }
        }
        
        int ans = 0, mx = -1;
        for(int i = 0; i < n; i++) {
            if(count[i] > mx) {
                mx = count[i];
                ans = i;
            }
        }
        return ans;
    }
}