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
    int cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        if (root == null) return 0;

        pathSumHelper(root, (long)targetSum, map, root.val);
        return cnt;
    }

    public void pathSumHelper(TreeNode node, long tar, HashMap<Long, Long> map, long ps) {
        if (map.containsKey(ps - tar)) cnt += map.get(ps - tar);

        if (map.containsKey(ps)) {
            map.put(ps, map.get(ps) + 1);
        } else {
            map.put(ps, 1L);
        }

        if (node.left != null) pathSumHelper(node.left, tar, map, ps + node.left.val);
        if (node.right != null) pathSumHelper(node.right, tar, map, ps + node.right.val);

        if (map.containsKey(ps)) {
            map.put(ps, map.get(ps) - 1);
        }
    }
}
