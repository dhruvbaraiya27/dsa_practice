/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        int n1Value = n1.data;
        int n2Value = n2.data;
        
        while(root!=null)
        {
            int rootValue = root.data;
            
            if(n1Value < rootValue && n2Value < rootValue)
            {
                root= root.left;
            }
            else if(n1Value > rootValue && n2Value > rootValue)
            {
                root= root.right;
            }
            else return root;
        }
        return null;
    }
}
