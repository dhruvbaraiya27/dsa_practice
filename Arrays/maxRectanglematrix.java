//{ Driver Code Starts
import java.util.*;

class FindMinCost {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().maxArea(arr));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    // Returns area of the largest rectangle with all 1s in mat[][]
    private static int[] nextSmaller(int arr[])
    {
        int n=arr.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=n-1;i>=0;i--)
        {
            int curr = arr[i];
            while(stack.peek()!=-1 && arr[stack.peek()] >= curr)
            {
                stack.pop();
            }
            next[i] = stack.peek();
            stack.push(i);
        }
        return next;
    }
    private static int[] prevSmaller(int arr[])
    {
        int n=arr.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=0;i<n;i++)
        {
            int curr = arr[i];
            while(stack.peek()!=-1 && arr[stack.peek()] >= curr)
            {
                stack.pop();
            }
            prev[i] = stack.peek();
            stack.push(i);
        }
        return prev;
    }
    
    private static int largestArea(int arr[])
    {
        int n=arr.length;
        int area=Integer.MIN_VALUE;
        int[] next = nextSmaller(arr);
        int[] prev = prevSmaller(arr);
        for(int i=0;i<n;i++)
        {
            int length=arr[i];
            if(next[i]==-1)
            {
                next[i]=n;
            }
            int breadth = next[i]-prev[i]-1;
            
            area = Math.max(area,length*breadth);
            
        }
        return area;
    }
    static int maxArea(int mat[][]) {
        // Your code here
        int rows = mat.length;
        int cols = mat[0].length;
        
        int area = largestArea(mat[0]);
        
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j]!=0)
                {
                    mat[i][j]+=mat[i-1][j];
                }
                else 
                {
                    mat[i][j]=0;
                }
                
            }
            area=Math.max(area,largestArea(mat[i]));
        }
        return area;
    }
}
