class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            return a[0] - b[0];
        });
        
        int[] count = new int[n];
        long[] rooms = new long[n]; //time when it gets free
        Arrays.fill(rooms, -1);
        
        for(int i = 0; i < meetings.length; i++) {
            int s = meetings[i][0], e = meetings[i][1]; 
            long mn = Long.MAX_VALUE; 
            int index = -1;
            boolean assign = false;
            for(int j = 0; j < n; j++) {
                if(rooms[j] < mn) {
                    mn = rooms[j];
                    index = j;
                }
                if(rooms[j] <= s) {
                    rooms[j] = e;
                    count[j]++;
                    assign = true;
                    break;
                }
            }
            
            if(!assign) {
                count[index]++;
                rooms[index] = mn + (e - s);
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