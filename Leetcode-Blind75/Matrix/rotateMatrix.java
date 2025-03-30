class Solution {
    
    public void rotate(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for(int i=0;i<rows/2;i++)
        {
            int[] temp = mat[i];
            mat[i] = mat[rows-i-1];
            mat[rows-i-1]=temp;
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=i;j<cols;j++)
            {
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
    }
}
