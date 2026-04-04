// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dis[]=new int[V];
        Arrays.fill(dis,(int)1e8);
        dis[src]=0;
        for(int j=0;j<V-1;j++){
           for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            if(dis[u]!=(int)1e8 && dis[u]+wt<dis[v]){
                dis[v]=dis[u]+wt;
            }
          } 
        }
        //For nth node relaxation check negative cycle
         for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            if(dis[u]!=(int)1e8 && dis[u]+wt<dis[v]){
                int temp[]=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dis;
        
    }
}
