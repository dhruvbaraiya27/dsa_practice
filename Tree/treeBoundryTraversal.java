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
    private void traverseLeft(Node node, ArrayList<Integer> list)
    {
        if(node ==null || (node.left==null && node.right==null))    return;
        
        list.add(node.data);
        if(node.left!= null) traverseLeft(node.left, list);
        else    traverseLeft(node.right, list);
    }
    
    private void traverseLeaf(Node node, ArrayList<Integer> list)
    {
        if(node==null)  return;
        
        if(node.left==null && node.right ==null){
            list.add(node.data);
            return;
        }
        traverseLeaf(node.left, list);
        traverseLeaf(node.right, list);
    }
    
    private void traverseRight(Node node, ArrayList<Integer> list)
    {
        if(node ==null || (node.left==null && node.right==null))    return;
        
        if(node.right!=null)    traverseRight(node.right, list);
        else    traverseRight(node.left, list);
        
        list.add(node.data);
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        if(node ==null) return new ArrayList<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node.data);
        
        traverseLeft(node.left, list);
        traverseLeaf(node.left, list);
        traverseLeaf(node.right, list);
        
        traverseRight(node.right, list);
        
        return list;
    }
}
