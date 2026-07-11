class Solution {
    public int[] findOrder(int num, int[][] edges) {
     List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<num;i++){
            graph.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
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
            ans.add(curr);
            c++;
            for(int node : graph.get(curr)){
                in[node]--;
                if(in[node]==0){
                    q.add(node);
                }
            }
        }
        int[] arr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }
        if(num==ans.size()){

        return arr;
        }
        return new int[0];
    }
}
