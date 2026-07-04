class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist,inf);
        dist[k]=0;

        for(int i=1;i<n;i++){
            for(int[] f : times){
                int u = f[0];
                int v = f[1];
                int w = f[2];

                if(dist[u]!=inf && dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }
            int ans = 0;
            for(int j=1;j<=n;j++){
            if(dist[j]==Integer.MAX_VALUE) return -1;
            ans = Math.max(dist[j],ans);
            }
        return ans;
    }
}
