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

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root ==  null) return null;
        
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
            
        }else if(key < root.val){
            root.left = deleteNode(root.left, key);
            return root;
            
        }else{
            
            if(root.left == null && root.right == null){
                return  null;
                
            }else if(root.left == null){ //having only right children
                return root.right;
                
            }else if(root.right == null){ //having only left children
                return root.left;         
            }else{
                
                int lmax = maxL(root.left);
                root.val = lmax;
                root.left = deleteNode(root.left, lmax);
                return root;
            }
        }
    }
    
    public int maxL(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        
        return root.val;
    }
}
