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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int odd = 1;
        while(q.size() > 0) {
            int sz = q.size();
            int prev = 0;
            for(int i = 0; i < sz; i++) {
                TreeNode u = q.poll();
                if(u.left != null) q.add(u.left);
                if(u.right != null) q.add(u.right);
                if((prev != 0 && u.val * odd <= prev * odd) || (u.val % 2 != (odd < 0 ? odd + 1 : odd))) return false; 
                prev = u.val;
            }
            odd *= -1;
        }
        return true;
    }
}