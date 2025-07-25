// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    
    public int kthSmallest(Node root, int k) {
        // Write your code here
        int count =0;
        int result =-1;
        
        Node curr = root;
        while(curr!=null)
        {
            if(curr.left == null)
            {
                count++;
                if(count==k)    result= curr.data;
                curr = curr.right;
            }
            else
            {
                Node pred = curr.left;
                while(pred.right!= null && pred.right!=curr)
                {
                    pred = pred.right;
                }
                if(pred.right == null)
                {
                    pred.right = curr;
                    curr = curr.left;
                }
                else
                {
                    pred.right = null;
                    count++;
                    if(count==k)    result = curr.data;
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
