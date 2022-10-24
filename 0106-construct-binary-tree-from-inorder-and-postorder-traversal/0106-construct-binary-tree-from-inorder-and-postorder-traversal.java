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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            int val = inorder[i];
             map.put(val, i);
        }
        
        TreeNode root = construct(0, inorder.length - 1, 0, postorder.length - 1, postorder, map);
        return root;
    }
    
    public TreeNode construct(int ino_lo, int ino_hi, int post_lo, int post_hi, int[] post, HashMap<Integer, Integer> map){
       if(ino_lo > ino_hi)
           return null;
        
        TreeNode node = new TreeNode();
        node.val = post[post_hi];
        
        int idx = map.get(post[post_hi]);
        int lhs = ino_hi - idx; //elements in right
        
        node.left = construct(ino_lo, idx - 1, post_lo, post_hi - lhs - 1, post, map);
        node.right = construct(idx + 1, ino_hi, post_hi - lhs ,post_hi - 1, post, map);
        
        return node;
    }
}