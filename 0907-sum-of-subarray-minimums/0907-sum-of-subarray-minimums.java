class Solution {
    final int MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        Stack<int[]> stk = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(stk.size() > 0 && arr[i] < arr[stk.peek()[0]]) {
                stk.pop();
            }
            int sum = 0;
            if(stk.size() == 0) {
                sum = (int)(((i + 1l) * arr[i]) % MOD);
            } else {
                int last = stk.peek()[0];
                sum = (int)(((i - last + 0l) * arr[i]) % MOD);
                sum += stk.peek()[1];
                sum %= MOD;
            }
            res += sum;
            res %= MOD;
            stk.push(new int[]{i, sum});
        }
        return (int)(res);
    }
}