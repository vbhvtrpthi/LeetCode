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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> flist = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null)
             return flist;
        
        q.add(root);
        q.add(null);
        
        List<Integer> list = new ArrayList<>();
        
        while(q.size() > 0){
            TreeNode node = q.remove();
            
            if(node != null){
                list.add(node.val);
                
                if(node.left != null)
                     q.add(node.left);
                
                if(node.right != null)
                    q.add(node.right);
            }else{
                flist.add(list);
                list = new ArrayList<>();
                if(q.size() > 0){
                    q.add(null);
                    System.out.println();
                }
            }
        }
        
        return flist;
    }
}