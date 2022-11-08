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

    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int cnt = 0;

        while (curr != null) {
            if (curr.left == null) {
                cnt++;
                if (cnt == k) return curr.val;
                curr = curr.right;
            } else {
                TreeNode iop = curr.left;

                while(iop.right != null && iop.right != curr) {
                    iop = iop.right;
                }

                //left is not processed
                if (iop.right == null) {
                    iop.right = curr;
                    curr = curr.left;
                }

                //left is processed
                if (iop.right == curr) {
                    iop.right = null;
                    cnt++;
                    if (cnt == k) return curr.val;

                    curr = curr.right;
                }
            }
        }
        
    return 0;
    }
}
