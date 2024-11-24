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
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        
        if (root == null) {
            return maxDepth;
        } 
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int targetSize = queue.size();
            
            for(int i = 0; i < targetSize; i++) {
                TreeNode curNode = queue.poll();

                if(curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            maxDepth++;;
        }
        
        return maxDepth;
    }
}