class Solution {
    public boolean canFinish(int num, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<num;i++){
            graph.add(new ArrayList<>());
        }
        int c=0;
        int[] in = new int[num];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<num;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            c++;
            for(int node : graph.get(curr)){
                in[node]--;
                if(in[node]==0){
                    q.add(node);
                }
            }
        }
        return c==num;
    }
}
