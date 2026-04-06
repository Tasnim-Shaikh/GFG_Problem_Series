class pair{
    int node,wt;
    pair(int n,int w){
        node=n;
        wt=w;
    }
}
class qpair{
    int wt,node,parent;
    qpair(int w,int n,int p){
        wt=w;
        node=n;
        parent=p;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new pair(v,wt));
            adj.get(v).add(new pair(u,wt));
        }
        boolean vis[]=new boolean[V];
        PriorityQueue<qpair> pq=new PriorityQueue<qpair>((x,y)->x.wt-y.wt);
        pq.add(new qpair(0,0,-1));
        int sum=0;
        while(!pq.isEmpty()){
            int wt=pq.peek().wt;
            int n=pq.peek().node;
            int p=pq.peek().parent;
            pq.poll();
            if(!vis[n]){
                vis[n]=true;
                sum+=wt;
                for(int i=0;i<adj.get(n).size();i++){
                    int nnode=adj.get(n).get(i).node;
                    int nwt=adj.get(n).get(i).wt;
                    pq.add(new qpair(nwt,nnode,n));
                    
                }
            }
        }
        return sum;
        
    }
}
