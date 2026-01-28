class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> answer=new ArrayList<>();
        int n=maze.length;
        int[][] vis=new int[n][n];
        if(maze[0][0]==1){
            solve(0,0,maze,n,answer,"",vis);
        }
        return answer;
    }
    void solve(int i,int j,int[][] grid,int n,List<String> answer,String temp,int[][] vis){
        if(i==n-1 && j==n-1){
            answer.add(temp);
            return;
        }
        //Check for downward
        if(i+1<n && vis[i+1][j]==0 && grid[i+1][j]==1){
            vis[i][j]=1;
            solve(i+1,j,grid,n,answer,temp+"D",vis);
            vis[i][j]=0;
        }
        //check for leftward
        if(j-1>=0 && vis[i][j-1]==0 && grid[i][j-1]==1){
            vis[i][j]=1;
            solve(i,j-1,grid,n,answer,temp+"L",vis);
            vis[i][j]=0;
        }
        //check rightward
        if(j+1<n && vis[i][j+1]==0 && grid[i][j+1]==1){
            vis[i][j]=1;
            solve(i,j+1,grid,n,answer,temp+"R",vis);
            vis[i][j]=0;
        }
        //check upward
        if(i-1>=0 && vis[i-1][j]==0 && grid[i-1][j]==1){
            vis[i][j]=1;
            solve(i-1,j,grid,n,answer,temp+"U",vis);
            vis[i][j]=0;
        }
    }
}