/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        helper(root, sb);

        return sb.toString();
    }

    public void helper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(".");
            sb.append(" ");
            return;
        }

        sb.append(node.val);
        sb.append(" ");
        helper(node.left, sb);
        helper(node.right, sb);
    }

    class Pair {
        TreeNode node;
        int state;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        //data array
        String[] darray = data.split(" ");

        Stack<Pair> st = new Stack<>();
        Pair rt = new Pair();
        rt.node = new TreeNode(Integer.parseInt(darray[0]));
        st.push(rt);
        int idx = 0;

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 0) {
                idx++;
                top.state++;

                if (darray[idx].equals(".") == false) {
                    Pair lp = new Pair();
                    lp.node = new TreeNode(Integer.parseInt(darray[idx]));
                    top.node.left = lp.node;

                    st.push(lp);
                }
            } else if (top.state == 1) {
                idx++;
                top.state++;

                if (darray[idx].equals(".") == false) {
                    Pair rp = new Pair();
                    rp.node = new TreeNode(Integer.parseInt(darray[idx]));
                    top.node.right = rp.node;

                    st.push(rp);
                }
            } else {
                st.pop();
            }
        }
        
        return rt.node;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
