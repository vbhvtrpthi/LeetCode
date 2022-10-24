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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            int val = inorder[i];
            map.put(val, i);
        }

        TreeNode root = construct(0, preorder.length - 1, 0, inorder.length - 1, preorder, map);
        return root;
    }

    public TreeNode construct(int pre_lo, int pre_hi, int in_lo, int in_hi, int[] preorder, HashMap<Integer, Integer> map) {
        if (pre_lo == pre_hi) {
            TreeNode node = new TreeNode();
            node.val = preorder[pre_lo];
            node.left = null;
            node.right = null;

            return node;
        }
        
        if(pre_lo > pre_hi)
             return null;

        TreeNode node = new TreeNode();
        node.val = preorder[pre_lo];
        int idx = map.get(preorder[pre_lo]);
        int lhs = idx - in_lo; //people in lhs

        node.left = construct(pre_lo + 1, pre_lo + lhs, in_lo, idx - 1, preorder, map);
        node.right = construct(pre_lo + lhs + 1, pre_hi, idx + 1, in_hi, preorder, map);

        return node;
    }
}
