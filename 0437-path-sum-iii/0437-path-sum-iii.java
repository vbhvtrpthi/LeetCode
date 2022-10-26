class Solution {
    int count = 0;
    int mod = 1000000007;
    
    public int pathSum(TreeNode root, int targetSum) {
        ArrayList<TreeNode> list = new ArrayList<>();
        travel1(root, list);

        for (TreeNode node : list) {
            travel2(node, 0, targetSum);
        }

        return count;
    }

    public void travel1(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }

        list.add(node);
        travel1(node.left, list);
        travel1(node.right, list);
    }

    public void travel2(TreeNode node, int csum, int targetSum) {
        if (node == null) {
            return;
        }
        if ((csum + node.val) % mod == targetSum) {
            count++;
        }

        travel2(node.left, (csum + node.val) % mod, targetSum);
        travel2(node.right, (csum + node.val) % mod, targetSum);
    }
}
