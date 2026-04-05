// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        int n=dist.length;
        int m=dist[0].length;
        int ans[][]=new int[n][m];
               
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==(int)1e8 || dist[k][j]==(int)1e8)continue;
                    if(dist[i][j]==(int)1e8){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                    else{
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
    }
}