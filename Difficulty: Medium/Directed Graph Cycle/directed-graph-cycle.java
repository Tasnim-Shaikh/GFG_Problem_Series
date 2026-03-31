class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //Using DFS
        // ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        // for(int i=0;i<V;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0;i<edges.length;i++){
        //     int u=edges[i][0];
        //     int v=edges[i][1];
        //     adj.get(u).add(v);
        // }
        // int vis[]=new int[V];
        // int pathvis[]=new int[V];
        // for(int i=0;i<V;i++){
        //     if(vis[i]==0){
        //         if(dfs(i,adj,vis,pathvis)==true)return true;
        //     }
        // }
        // return false;
        
        
        //Using BFS (Kahn's Algorithm / topo sort)
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q =new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int node:adj.get(i)){
                indegree[node]++;
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            ans.add(q.poll());
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        if(ans.size()<V)return true;
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