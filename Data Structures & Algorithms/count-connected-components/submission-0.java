class Solution {
    public int countComponents(int num, int[][] edges) {
        int n = edges.length;
        int[] parent  = new int[num];
        int[] size = new int[num];
        int count=num;
        for(int i=0;i<num;i++){
            parent[i] = i;
            size[i] = 1;
        }
      for(int[] edge : edges){
          int u = edge[0];
          int v = edge[1];

          int pu = find(u,parent);
          int pv  = find(v,parent);

          if(pv==pu) continue; 
                  count--;
          if(size[pu]<size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu]; 
        }  else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }

      }
      return count;  
    }
    int find(int x,int[] parent){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x],parent);
    }
}
