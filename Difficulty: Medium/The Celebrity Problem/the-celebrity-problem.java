class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int knownby[]=new int[mat[0].length];
        int iknow[]=new int[mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    knownby[j]++;
                    iknow[i]++;
                }
            }
        }
        for(int i=0;i<mat[0].length;i++){
            if(knownby[i]==mat[0].length && iknow[i]<=1){
                return i;
            }
        }
        return -1;
    }
}