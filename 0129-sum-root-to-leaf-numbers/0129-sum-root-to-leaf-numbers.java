class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, new StringBuilder());
        return sum;
    }

    public void sumNumbersHelper(TreeNode node, StringBuilder psf) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            psf.append(node.val);
            sum += Integer.parseInt(psf.toString());
            psf.deleteCharAt(psf.length() - 1);
            return;
        }
        
        psf.append(node.val);
        sumNumbersHelper(node.left, psf);
        sumNumbersHelper(node.right, psf);
        psf.deleteCharAt(psf.length() - 1); //as string builder is made in heap;
    }
}