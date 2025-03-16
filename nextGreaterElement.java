class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n=arr.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        

        for(int i=0;i<n;i++)
        {
            ans.add(-1);
        }
        
        for(int i=n-1;i>=0;i--)
        {
            int curr = arr[i];
            while(!stack.isEmpty() && curr >=stack.peek())
            {
                stack.pop();
            }
            if(!stack.isEmpty()) ans.set(i, stack.peek());
            stack.push(curr);
        }
        return ans;
    }
}
