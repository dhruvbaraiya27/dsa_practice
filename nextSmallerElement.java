public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            ans.add(-1);
        }

        for(int i=n-1;i>=0;i--)
        {
            int curr = arr.get(i);
            while(curr <=stack.peek())
            {
                stack.pop();
            }

            ans.set(i,stack.peek());
            stack.push(curr);
        }
        return ans;
       
    }
}
