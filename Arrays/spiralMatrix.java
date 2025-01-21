//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int rows = mat.length;
        int cols = mat[0].length;
        
        int total = rows*cols;
        
        int startRow = 0;
        int startCol =0;
        int endRow = rows-1;
        int endCol = cols-1;
        
        int count=0;
        while(count<total)
        {
            for(int i=startCol;i<=endCol && count<total ;i++)
            {
                list.add(mat[startRow][i]);
                count++;
            }
            startRow++;
            
            for(int i=startRow;i<=endRow && count<total;i++)
            {
                list.add(mat[i][endCol]);
                count++;
            }
            endCol--;
            for(int i=endCol;i>=startCol && count<total;i--)
            {
                list.add(mat[endRow][i]);
                count++;
            }
            endRow--;
            
            for(int i=endRow;i>=startRow && count<total;i--)
            {
                list.add(mat[i][startCol]);
                count++;
            }
            startCol++;
        }
        return list;
    }
}
