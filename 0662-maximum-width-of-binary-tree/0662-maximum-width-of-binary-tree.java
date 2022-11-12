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

    class Pair {
        long min;
        long max;
    }

    long maxw = 0l;

    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Pair> map = new HashMap<>();
        helper(root, 1, 1, map);
        return (int) maxw;
    }

    public void helper(TreeNode node, int level, long idx, HashMap<Integer, Pair> map) {
        if (node == null) {
            return;
        }

        helper(node.left, level + 1, 2 * idx, map);
        helper(node.right, level + 1, 2 * idx + 1, map);

        Pair p = null;
        if (map.containsKey(level)) {
            p = map.get(level);
            p.max = idx;
        } else {
            p = new Pair();
            p.min = idx;
            p.max = idx;
            map.put(level, p);
        }

        maxw = Math.max(maxw, p.max - p.min + 1);
    }
}
