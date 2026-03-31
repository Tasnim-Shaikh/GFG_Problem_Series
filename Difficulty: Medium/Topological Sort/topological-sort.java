class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        boolean vis[]=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }
    void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=true;
        for(int i:adj.get(node)){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        st.push(node);
    }
}