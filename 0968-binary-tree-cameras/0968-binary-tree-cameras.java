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
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        
        if(minCameraCoverHelper(root) == -1) cameras++;
        return cameras;
    }
    
    public int minCameraCoverHelper(TreeNode root){
        if(root == null) return 1;
        
        int lc = minCameraCoverHelper(root.left);
        int rc = minCameraCoverHelper(root.right);
        
        if(lc == -1 || rc == -1){
            cameras++;
            return 0;
        }
        
        if(lc == 0 || rc == 0) return 1;
        
        return -1;
    }
}