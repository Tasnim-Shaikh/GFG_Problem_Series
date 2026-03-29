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
                if(checkcycle(i,V,adj,vis))return true;
            }
        }
        return false;
    }
    boolean checkcycle(int src,int V,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        // boolean vis[]=new boolean[V];
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(src,-1));
        vis[src]=true;
        while(!q.isEmpty()){
            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();
            for(int n:adj.get(node)){
                if(!vis[n]){
                    vis[n]=true;
                    q.offer(new pair(n,node));
                }
                else if(n!=parent){
                    return true;
                }
            }
            
        }
        return false;
    }
}