// User function Template for Java
class pair{
    int dis,row,col;
    pair(int d,int r,int c){
        dis=d;
        row=r;
        col=c;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // Your code here
        if(source[0]==destination[0] && source[1]==destination[1])return 0;
        int n=grid.length;
        int m=grid[0].length;
        int dis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)1e9;
            }
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,source[0],source[1]));
        dis[source[0]][source[1]]=0;
        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};
        while(!q.isEmpty()){
            int d=q.peek().dis;
            int r=q.peek().row;
            int c=q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=dc[i]+c;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && dis[nrow][ncol]>d+1){
                    dis[nrow][ncol]=d+1;
                    if(nrow==destination[0] && ncol==destination[1])return d+1;
                    q.add(new pair(d+1,nrow,ncol));
                }
            }
        }
        return -1;
    }
}
