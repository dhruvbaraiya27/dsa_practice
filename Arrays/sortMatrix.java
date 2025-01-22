class Solution {
    int[][] sortedMatrix(int N, int Mat[][]) {
        // code here
        List<Integer> list = new ArrayList<>();
        int rows = Mat.length;
        int cols = Mat[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                list.add(Mat[i][j]);
            }
        }
        Collections.sort(list);
        int k=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                Mat[i][j]=list.get(k++);
            }
        }
        return Mat;
    }
};
