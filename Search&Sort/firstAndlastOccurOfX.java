//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class GFG {
    
    private int firstOccur(int arr[], int x)
    {
        int index=-1;
        int low=0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid]  ==x)
        {
            index=mid;
            high=mid-1;
        }
        else if(arr[mid] > x)
        {
            high=mid-1;
        }
        else
        {
            low=mid+1;
        }
        }
        return index;
    }
    private int lastOccur(int arr[], int x)
    {
        int index=-1;
        int low=0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] ==x)
        {
            index=mid;
            low=mid+1;
        }
        else if(arr[mid] > x)
        {
            high=mid-1;
        }
        else
        {
            low=mid+1;
        }
        }
        return index;
    }
    
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(firstOccur(arr,x));
        list.add(lastOccur(arr,x));
        
        return list;
        
    }
    
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            int x = Integer.parseInt(br.readLine());
            GFG ob = new GFG();
            ArrayList<Integer> ans = ob.find(arr, x);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
