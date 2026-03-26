class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[adj.size()];
        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer i:adj.get(node)){
                if(!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
        return bfs;
    }
}