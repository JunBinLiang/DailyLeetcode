class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            return y - x;
        });
        int sum = 0;
        int ans = 0;
        for(int i = 1; i < heights.length; i++) {
            if(heights[i] > heights[i - 1]) {
                //System.out.println("before " + i + "  " + pq + "  " + bricks + "  " + ladders);
                int diff = heights[i] - heights[i - 1];
                if(bricks >= diff) {
                    pq.add(diff);
                    bricks -= diff;
                } else if(ladders > 0) {
                    while(bricks < diff && pq.size() > 0 && ladders > 0 && pq.peek() > diff) {
                        ladders--;
                        bricks += pq.poll();
                    }
                    
                    if(bricks < diff) {
                        if(ladders > 0) ladders--;
                        else break;
                    }
                    else {
                        pq.add(diff);
                        bricks -= diff;
                    }
                    //System.out.println("after " + i + " " + pq + "  " + bricks + "  " + ladders);
                } else {
                    break;
                }
            }
            ans = i;
        }
        return ans;
    }
}