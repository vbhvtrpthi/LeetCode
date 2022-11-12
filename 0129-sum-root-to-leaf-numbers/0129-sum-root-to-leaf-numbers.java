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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, "");
        return sum;
    }
    
    public void sumNumbersHelper(TreeNode node, String psf){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            psf += node.val;
            sum += Integer.parseInt(psf);
            return;
        }
        
        sumNumbersHelper(node.left, psf + node.val);
        sumNumbersHelper(node.right, psf + node.val);
    }
}