/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {
    public ArrayList<Integer> reverseLevelOrder(Node root) {
        // code here
        if(root==null)  return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s= new Stack<>();
        
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            
            s.push(temp);
            
            if(temp.right!=null)    q.add(temp.right);
            if(temp.left!=null) q.add(temp.left);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!s.isEmpty())
        {
            list.add(s.pop().data);
        }
        return list;
    }
}
