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
    
    
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    private void inorder(Node root, ArrayList<Integer> list)
    {
        if(root == null)    return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    private ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList<Integer> list3 = new ArrayList<>();
        int n1 = list1.size();
        int n2 = list2.size();
        int i=0, j=0;
        
        while(i< n1 && j<n2)
        {
            if(list1.get(i) < list2.get(j))
            {
                list3.add(list1.get(i++));
            }
            else
            {
                list3.add(list2.get(j++));
            }
        }
        while(i<n1)
        {
            list3.add(list1.get(i++));
        }
        while(j<n2)
        {
            list3.add(list2.get(j++));
        }
        return list3;
    }
    
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // Write your code here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        inorder(root1, list1);
        inorder(root2, list2);
        
        ArrayList<Integer> list3 = mergeList(list1, list2);
        
        return list3;
        
        
        
        
        
        
        
    }
}
