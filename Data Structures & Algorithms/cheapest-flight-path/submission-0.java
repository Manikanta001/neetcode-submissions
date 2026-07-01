class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(dist, inf);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = dist.clone();

            for (int[] f : flights) {
                int u = f[0];
                int v = f[1];
                int w = f[2];

                if (dist[u] != inf && dist[u] + w < temp[v]) {
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        return dist[dst] == inf ? -1 : dist[dst];
    }
}
