class Solution {
    public void setZeroes(int[][] mat) {
        int n=mat[0].length;
        int m=mat.length;
        boolean firstRowZero=false, firstColZero=false;

        for(int i=0;i<n;i++)
        {
            if(mat[0][i]==0)
            {
                firstRowZero=true;
                break;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(mat[i][0]==0)
            {
                firstColZero=true;
                break;
            }
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    mat[0][j]=0;
                    mat[i][0]=0;
                }
            }
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(mat[0][j]==0 || mat[i][0]==0)
                {
                    mat[i][j]=0;
                }
            }
        }
        if(firstRowZero)
        {
            for(int i=0;i<n;i++)
            {
                mat[0][i]=0;
            }
        }
        if(firstColZero)
        {
            for(int i=0;i<m;i++)
            {
                mat[i][0]=0;
            }
        }
        
    }
}
