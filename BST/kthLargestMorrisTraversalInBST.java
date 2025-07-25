/*
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
*/
class Solution {
    
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        int count =0;
        int result = -1;
        Node curr = root;
        
        while(curr!=null)
        {
            if(curr.right== null)
            {
                count++;
                if(count==k)    result = curr.data;
                curr = curr.left;
            }
            else
            {
                Node succ = curr.right;
                while(succ.left!=null && succ.left!=curr)
                {
                    succ = succ.left;
                }
                if(succ.left == null)
                {
                    succ.left = curr;
                    curr = curr.right;
                }
                else 
                {
                    succ.left = null;
                    count++;
                    if(count==k)    result = curr.data;
                    curr=curr.left;
                }
            }
        }
        return result;
        
    }
}
