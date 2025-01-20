//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
       int start = 0;
       int end = arr.length-1;
       
       while(start <= end)
       {
           int mid = start + (end-start)/2;
           
           if(key==arr[mid])
           {
               return mid;
           }
           else if(arr[mid]>=arr[start])
           {
               if(key>=arr[start] && key<arr[mid])
               {
                   
                   end=mid-1;
               }
               else 
               {
                   start=mid+1;
               }
           }
           else 
           {
               if(key>=arr[start] && key<arr[mid])
               {
                   
                   start=mid+1;
               }
               else 
               {
                   end=mid-1;
               }
           }
       }
       return -1;
    }
}
