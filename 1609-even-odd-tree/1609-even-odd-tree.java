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
        int level = 0;
        q.add(root);
        while(q.size() > 0) {
            int sz = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < sz; i++) {
                TreeNode u = q.poll();
                list.add(u.val);
                if(u.left != null) q.add(u.left);
                if(u.right != null) q.add(u.right);
            }
            if(level % 2 == 1) Collections.reverse(list);
            level++;
            if(!check(list, level % 2)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean check(List<Integer> list, int v) {
        for(int i = 1; i < list.size(); i++) {
            int x = list.get(i), y = list.get(i - 1);
            if(x <= y) {
                return false;
            }
        }
        
        for(int x : list) {
            if((x % 2) != v) {
                return false;
            }
        }
        
        return true;
    }
}