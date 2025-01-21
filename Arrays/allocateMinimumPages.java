//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    
    private static boolean isPossible(int[] arr,int mid, int k)
    {
        int studentCount=1;
        int pageSum=0;
        
        for(int pages: arr)
        {
            if(pageSum + pages > mid)
            {
                studentCount++;
                pageSum=pages;
            }
            else
            {
                pageSum+=pages;
            }
        }
        if(studentCount>k)
        {
            return false;
        }
        return true;
    }
    public static int findPages(int[] arr, int k) {
        if(k>arr.length)
        {
            return -1;
        }
        // code here
        int low= Integer.MIN_VALUE;
        int high=0;
        
        for(int ele:arr)
        {
            low = Math.max(low,ele);
            high+=ele;
        }
        int ans=-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(isPossible(arr,mid,k))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
        
    }
}
