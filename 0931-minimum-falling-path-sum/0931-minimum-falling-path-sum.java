class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] d = new int[]{-1, 0, 1};
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for(int shift : d) {
                    int c = j + shift;
                    if(c >= 0 && c < matrix[0].length && i - 1 >= 0) {
                        min = Math.min(min, matrix[i][j] + matrix[i - 1][c]);
                    }
                }
                matrix[i][j] = min;
            }
        }
        
        for(int j = 0; j < matrix[0].length; j++) {
            res = Math.min(res, matrix[matrix.length - 1][j]);
        }
        
        return res;
    }
}