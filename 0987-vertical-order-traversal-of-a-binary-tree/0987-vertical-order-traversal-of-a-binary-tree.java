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
    List<int[]> list = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        
        Collections.sort(list, (p1, p2) -> {
            int x1 = p1[0], y1 = p1[1];
            int x2 = p2[0], y2 = p2[1];
            //sort on x first, then y
            if(x1 == x2) {
                if(y1 == y2) {
                    return p1[2] - p2[2]; //same x and y, sorted base on value
                }
                return y1 - y2;
            } else {
                return x1 - x2;
            }
        });
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            List<Integer> line = new ArrayList<>();
            int j = i;
            while(j < list.size() && list.get(j)[0] == list.get(i)[0]) {
                line.add(list.get(j)[2]);
                j++;
            }
            ans.add(line);
            i = j - 1;
        }
        
        return ans;
    }
    
    public void dfs(TreeNode root, int x, int y) {
        if(root == null) {
            return;
        }
        
        list.add(new int[]{x, y, root.val});
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }
}