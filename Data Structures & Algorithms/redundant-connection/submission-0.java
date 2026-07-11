class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent  = new int[n+1];
        int[] size = new int[n+1];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
      for(int[] edge : edges){
          int u = edge[0];
          int v = edge[1];

          int pu = find(u,parent);
          int pv  = find(v,parent);

          if(pv==pu) return edge;

          if(size[pu]<size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu]; 
        }  else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
      }
      return new int[0];  
    }
    int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x],parent);
    }
}
