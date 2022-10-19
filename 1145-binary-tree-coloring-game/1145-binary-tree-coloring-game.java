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
    int xleft;
    int xright;
    public int size(TreeNode root, int x){
        if(root == null) return 0;
        int lcs = size(root.left, x);
        int rcs = size(root.right, x);
        if(root.val == x){
            xleft = lcs;
            xright = rcs;
        }
        
        int ts = lcs + rcs + 1;
        return ts;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root, x); 
        int os = n - (xleft + xright + 1);
        int max = Math.max(xleft, Math.max(xright, os));
        
        if(max > n/2)
            return true;
        else
            return false;
    }
}