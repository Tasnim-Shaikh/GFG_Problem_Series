/*Complete the function below*/
class GfG {
    int rank[]=new int[100005];

    int find(int par[], int x) {
        // add code here.
        if(x==par[x])return x;
        return par[x]=find(par,par[x]);
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        int ulp_x=find(par,x);
        int ulp_z=find(par,z);
        if(ulp_x!=ulp_z){
            par[ulp_x]=ulp_z;
        }
        // if(ulp_x==ulp_z)return;
        // if(rank[ulp_x]<rank[ulp_z]){
        //     par[ulp_x]=ulp_z;
        // }
        // else if(rank[ulp_z]<rank[ulp_x]){
        //     par[ulp_z]=ulp_x;
        // }
        // else{
        //     par[ulp_z]=ulp_x;
        //     rank[ulp_x]++;
        // }
    }
}