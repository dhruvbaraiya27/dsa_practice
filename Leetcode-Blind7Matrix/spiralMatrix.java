class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> list = new ArrayList<>();
        int rows = mat.length;
        int cols = mat[0].length;

        int total = rows*cols;

        int startingRow=0,startingCol=0, endingRow = rows-1, endingCol=cols-1;
        int count=0;
        while(count<total)
        {
            for(int i=startingCol;count<total && i<=endingCol;i++)
            {
                list.add(mat[startingRow][i]);
                count++;
            }
            startingRow++;
            for(int i=startingRow;count<total && i<=endingRow;i++)
            {
                list.add(mat[i][endingCol]);
                count++;
            }
            endingCol--;

            for(int i=endingCol;count<total && i>=startingCol;i--)
            {
                list.add(mat[endingRow][i]);
                count++;
            }
            endingRow--;
            for(int i=endingRow;count<total && i>=startingRow;i--)
            {
                list.add(mat[i][startingCol]);
                count++;

            }
            startingCol++;
        }
        return list;

    }
}
