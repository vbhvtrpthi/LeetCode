//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Main
{
    static Node buildTree(String str)
    {
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void main (String[] args) throws IOException
    {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t-- > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target=Integer.parseInt(br.readLine());
            
            Solution g = new Solution();
            ArrayList<Integer> nodes =  g.Ancestors(root, target);
            for(int i = 0;i<nodes.size();i++){
                System.out.print(nodes.get(i)+ " ");
            }
            System.out.println();
        }
	}
}


// } Driver Code Ends


/*class Node of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution
{
     static ArrayList<Integer> res;
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {  
        res = new ArrayList<>();
        if(root == null) return res;
        
        AncestorsHelper(root, target);
        return res;
        // add your code here
        
    }
    
    public static boolean AncestorsHelper(Node node, int tar){
      
        if(node == null)  return false;
        
          if(node.data == tar)
           return true;
        
        boolean lc = AncestorsHelper(node.left, tar);
        if(lc == true){
            res.add(node.data);
            return true;
        }
        
        boolean rc = AncestorsHelper(node.right, tar);
        if(rc == true){
            res.add(node.data);
            return true;
        }
        
        return false;
    }
}