/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    private static HashMap<Integer, Integer> idxMap;
    private static Node build(int inorder[], int inStart, int inEnd, int preorder[], int preStart, int preEnd)
    {
        if(inStart > inEnd || preStart > preEnd)    return null;
        int rootVal = preorder[preStart];
        Node root = new Node(rootVal);
        
        int rootIndex = idxMap.get(rootVal);
        int numsLeft = rootIndex-inStart;
        
        root.left = build(inorder, inStart, rootIndex-1, preorder, preStart+1, preStart+numsLeft);
        root.right = build(inorder, rootIndex+1, inEnd, preorder, preStart+numsLeft+1, preEnd);
        
        return root;
        
        
    }
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        idxMap =  new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            idxMap.put(inorder[i],i);
        }
        Node tree = build(inorder, 0,inorder.length-1,preorder, 0, preorder.length-1);
        return tree;
        
    }
}
