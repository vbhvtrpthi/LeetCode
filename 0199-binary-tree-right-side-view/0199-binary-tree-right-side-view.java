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
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        if(root == null)
             return list;
        
        queue.add(root);
        
        while(queue.size() > 0){
            int lsize = queue.size();
            
            for(int i = 0; i < lsize; i++){
                
               TreeNode temp = queue.remove();
                
                if(i == 0)
                     list.add(temp.val);
                
                if(temp.right != null)
                     queue.add(temp.right);
                
                if(temp.left != null)
                    queue.add(temp.left);
            }
        }
        
        return list;
       
    }
}