class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        int vis[]=new int[V];
        int pathvis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathvis)==true)return true;
            }
        }
        return false;
    }
    boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,int []vis,int pathvis[]){
        vis[node]=1;
        pathvis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathvis)==true)return true;
            }
            else if(pathvis[i]==1){
                return true;
            }
            
        }
        pathvis[node]=0;
        return false;
    }
}