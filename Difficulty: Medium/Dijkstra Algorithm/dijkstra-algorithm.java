class pair{
    int node,dist;
    pair(int d,int n){
        node=n;
        dist=d;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int d=edges[i][2];
            adj.get(u).add(new pair(d,v));
            adj.get(v).add(new pair(d,u));
        }
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.dist-y.dist);
        int dist[]=new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
        pq.add(new pair(0,src));
        while(!pq.isEmpty()){
            int n=pq.peek().node;
            int d=pq.peek().dist;
            pq.poll();
            for(int i=0;i<adj.get(n).size();i++){
                int currnode=adj.get(n).get(i).node;
                int currdis=adj.get(n).get(i).dist;
                if(currdis+d<dist[currnode]){
                    dist[currnode]=currdis+d;
                    pq.add(new pair(currdis+d,currnode));
                }
            }
        }
     
        return dist;
    }
}