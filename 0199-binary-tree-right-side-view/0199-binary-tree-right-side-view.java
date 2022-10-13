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
    public List<Integer> rightSideView(TreeNode root) {
        
      List<Integer> retVal = new ArrayList<>();
      
      if(root == null){
          return retVal;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while(queue.size() > 0){
          int lsize = queue.size();//level size

          for(int i = 0; i < lsize; i++){
              TreeNode temp = queue.remove();

              if(i == lsize - 1){
                  retVal.add(temp.val);
              }

              if(temp.left != null){
                  queue.add(temp.left);
              }

              if(temp.right != null){
                  queue.add(temp.right);
              }
          }
      }
     
      
      return retVal;
   
    }
}