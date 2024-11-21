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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()) {
            TreeNode pn = queue.poll();
            TreeNode qn = queue.poll();

            if(pn == null && qn == null) {
               continue;
            }
            else if(pn == null || qn == null || pn.val != qn.val){
                return false; 
            }
            else if(pn.val == qn.val) {
               queue.add(pn.left);
               queue.add(qn.left);
               queue.add(pn.right);
               queue.add(qn.right);
           }
      }
    
      return true;
    }
}