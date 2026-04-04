// User function Template for Java
class pair{
    int step,node;
    pair(int s,int n){
        step=s;
        node=n;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end)return 0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,start));
        int dist[]=new int[100000];
        Arrays.fill(dist,(int)1e9);
        dist[start]=0;
        int mod=100000;
        while(!q.isEmpty()){
            int s=q.peek().step;
            int n=q.peek().node;
            q.poll();
            for(int i=0;i<arr.length;i++){
                int newnode=(n*arr[i])%mod;
                if(s+1<dist[newnode]){
                    dist[newnode]=s+1;
                    if(newnode==end)return s+1;
                    q.add(new pair(s+1,newnode));
                }
                
            }
        }
        return -1;
    }
}
