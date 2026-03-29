class pair{
    int node,parent;
    pair(int n,int p){
        node=n;
        parent=p;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,-1,adj,vis))return true;
            }
        }
        return false;
    }
    boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        // boolean vis[]=new boolean[V];
        vis[node]=true;
        for(int n:adj.get(node)){
            if(!vis[n]){
                vis[n]=true;
                if(dfs(n,node,adj,vis))return true;
            }
            else if(n!=parent){
                return true;
            }
        }
        return false;
    }
}