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
        
        List<List<Integer>> flist = new ArrayList<>();
        Stack<List<Integer>> st = new Stack<>();
        
        if(root == null)
             return flist;
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        q.add(root);
        q.add(null);
        
        while(q.size() > 0){
            TreeNode node = q.remove();
            
            if(node != null){
                list.add(node.val);
                
                if(node.left != null)
                     q.add(node.left);
                if(node.right != null)
                     q.add(node.right);
            }else{
                st.push(list);
                list = new ArrayList<>();
                if(q.size() > 0){
                    q.add(null);
                }
            }
        }
        

        while(st.size() > 0){
            flist.add(st.pop());
        }
        
        return flist;
    }
}