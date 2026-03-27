class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[]=new boolean[V];
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                ArrayList<Integer> list=new ArrayList<>();
                bfs(adj,visited,i,list);
                result.add(list);
            }
        }
        return result;
    }
    void bfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],Integer node,ArrayList<Integer> list){
        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        visited[node]=true;
        while(!q.isEmpty()){
            Integer n=q.poll();
            list.add(n);
            for(Integer i:adj.get(n)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
}