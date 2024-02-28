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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = -1;
        q.add(root);
        while(q.size() > 0) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                TreeNode u = q.poll();
                if(u.left != null) q.add(u.left);
                if(u.right != null) q.add(u.right);
                if(i == 0) ans = u.val;
            }
        }
        
        return ans;
    }
}