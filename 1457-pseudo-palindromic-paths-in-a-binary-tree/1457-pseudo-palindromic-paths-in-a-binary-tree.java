/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        dfs(root, count);
        return res;
    }
    
    public boolean check(int[] count) {
        int x = 0;
        for(int i = 0; i < 10; i++) {
            x += (count[i] % 2);
        }
        return x <= 1;
    }
    
    public void dfs(TreeNode root, int[] count) {
        if(root == null) {
            return;
        }
        count[root.val]++;
        dfs(root.left, count);
        dfs(root.right, count);
        if(root.left == null && root.right == null && check(count)) {
            res++;
        }
        count[root.val]--;
    }
}