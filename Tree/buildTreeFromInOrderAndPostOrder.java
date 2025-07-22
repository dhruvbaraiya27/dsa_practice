class Solution {
    private HashMap<Integer, Integer> idxMap;
    private Node build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
    {
        if(inStart > inEnd || postStart > postEnd)  return null;
        
        int rootVal = postorder[postEnd];
        Node root = new Node(rootVal);
        int rootIndex = idxMap.get(rootVal);
        
        int numsLeft = rootIndex - inStart;
        
        root.left = build(inorder, inStart, rootIndex-1, postorder,postStart, postStart + numsLeft-1);
        root.right = build(inorder, rootIndex+1, inEnd, postorder, postStart + numsLeft, postEnd-1);
        
        return root;
    }
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        idxMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            idxMap.put(inorder[i], i);
        }
        Node tree = build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return tree;
        
    }
}
