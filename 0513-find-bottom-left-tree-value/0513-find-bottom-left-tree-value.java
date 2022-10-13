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
       int res = 0;
      
      if(root == null){
          return -1;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while(queue.size() > 0){
          int lsize = queue.size();//level size

          for(int i = 0; i < lsize; i++){
              TreeNode temp = queue.remove();

              if(i == 0) res = temp.val;

              if(temp.left != null){
                  queue.add(temp.left);
              }

              if(temp.right != null){
                  queue.add(temp.right);
              }
          }
      }
     
      
      return res;
    }
}