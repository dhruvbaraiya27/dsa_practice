/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node pred = null;
        Node succ = null;
        Node curr = root;
        ArrayList<Node> result = new ArrayList<>();
        
        while(curr!=null)
        {
            if(key < curr.data)
            {
                succ = curr;
                curr = curr.left;
            }
            else if(key > curr.data)
            {
                pred = curr;
                curr = curr.right;
            }
            else
            {
                if(curr.left!=null)
                {
                    pred = curr.left;
                    while(pred.right!=null) pred = pred.right;
                }
                if(curr.right!=null)
                {
                    succ=curr.right;
                    while(succ.left!=null) succ = succ.left;
                }
                break;
                
            }
        }
        result.add(pred);
        result.add(succ);
        return result;
        
    }
}
