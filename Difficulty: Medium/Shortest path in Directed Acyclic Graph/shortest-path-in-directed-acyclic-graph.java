// User function Template for Java
class pair{
    int node,dist;
    pair(int n,int d){
        node=n;
        dist=d;
    }
}
class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int d=edges[i][2];
            adj.get(u).add(new pair(v,d));
        }
        boolean vis[]=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,st);
            }
        }
        int dist[]=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[0]=0;
        while(!st.isEmpty()){
            int n=st.pop();
            for(int i=0;i<adj.get(n).size();i++){
                int v=adj.get(n).get(i).node;
                int d=adj.get(n).get(i).dist;
                if(dist[n]+d<dist[v]){
                    dist[v]=dist[n]+d;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
    void dfs(int node,ArrayList<ArrayList<pair>> adj,boolean vis[],Stack<Integer> st){
        vis[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int n=adj.get(node).get(i).node;
            if(!vis[n]){
                dfs(n,adj,vis,st);
            }
        }
        st.add(node);
    }
}