class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        int distance[]=new int[V];
        Arrays.fill(distance,(int)1e9);
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
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        distance[src]=0;
        while(!q.isEmpty()){
            int n=q.peek();
            q.poll();
            for(int i:adj.get(n)){
                if(distance[n]+1<distance[i]){
                    distance[i]=distance[n]+1;
                    q.offer(i);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(distance[i]==1e9){
                distance[i]=-1;
            }
        }
        return distance;
    }
}
