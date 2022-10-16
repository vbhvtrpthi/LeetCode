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
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int h;
        int v;
        
        Pair(TreeNode node, int h, int v){
            this.node = node;
            this.h = h;
            this.v = v;
        }
        
        public int compareTo(Pair other){
            if(this.v == other.v){
                return this.node.val - other.node.val;
            }else{
                return this.v - other.v;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        q.add(new Pair(root, 0, 1));
        
        //for sorting from left to right
        int lmh = 0;
        int rmh = 0;
        
        HashMap<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        
        while(q.size() > 0){
            
            Pair temp = q.remove();
            
            if(temp.h < lmh)
                 lmh = temp.h;
            
            if(temp.h > rmh)
                rmh = temp.h;
            
            if(map.containsKey(temp.h) == false){
                map.put(temp.h, new PriorityQueue<>());
                map.get(temp.h).add(temp);
            }else{
                map.get(temp.h).add(temp);
            }
            
            if(temp.node.left != null){
                q.add(new Pair(temp.node.left, temp.h - 1, temp.v + 1));
            }
            
            if(temp.node.right != null){
                q.add(new Pair(temp.node.right, temp.h + 1, temp.v + 1));
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = lmh; i <= rmh; i++){
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Pair> prq = map.get(i);
            
            
            while(prq.size() > 0){
                Pair temp = prq.remove();
                list.add(temp.node.val);
            }
            
            res.add(list);
        }
      return res;
    }
}