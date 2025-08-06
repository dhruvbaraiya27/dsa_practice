class Solution {
    
    private boolean isSafe(int newX, int newY,int[][] maze, boolean[][] visited, int n)
    {
        return newX>=0 && newX<n && newY>=0 && newY<n && maze[newX][newY]==1 && !visited[newX][newY];
    }
    
    
    private void solve(int x, int y, int[][] maze, boolean[][] visited, String path, ArrayList<String> result, int n)
    {
        
        if(x==n-1 && y==n-1)
        {
            result.add(path);
            return;
        }
        visited[x][y]=true;
        
        //D
        if(isSafe(x+1, y, maze, visited, n))
        {
            solve(x+1, y, maze, visited, path + 'D', result, n);
        }
        
        //L
        if(isSafe(x, y-1, maze, visited, n))
        {
            solve(x, y-1, maze, visited, path + 'L', result, n);
        }
        
        //R
        if(isSafe(x, y+1, maze, visited, n))
        {
            solve(x, y+1, maze, visited, path + 'R', result, n);
        }
        
        //U
        if(isSafe(x-1, y, maze, visited, n))
        {
            solve(x-1, y, maze, visited, path + 'U', result, n);
        }
        
        visited[x][y]=false;
        
    }
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        
        if(maze[0][0] == 1)
        {
            solve(0,0, maze, visited, "", result, n);
        }
        Collections.sort(result);
        return result; 
    }
}
