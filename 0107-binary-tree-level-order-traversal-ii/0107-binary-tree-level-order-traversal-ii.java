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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        List<Integer> list = new ArrayList<>();

        while (q.size() > 0) {
            TreeNode temp = q.remove();
            if (temp != null) list.add(temp.val);

            if (temp != null && temp.left != null) {
                q.add(temp.left);
            }

            if (temp != null && temp.right != null) {
                q.add(temp.right);
            }

            if (temp == null) {
                if (q.size() > 0) {
                    ret.add(list);
                    list = new ArrayList<>();
                    q.add(null);
                } else {
                    ret.add(list);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> val : ret) {
            ans.add(0, val);
        }

        return ans;
    }
}
