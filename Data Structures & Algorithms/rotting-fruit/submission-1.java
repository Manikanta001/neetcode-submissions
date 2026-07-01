class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int count=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(grid[i][j]==2){
                q.add(new int[]{i,j});
               } else if(grid[i][j]==1){
                fresh++;
               }
            }
        }
        if(fresh==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
            int[] node = q.remove();
            int i = node[0];
            int j = node[1];

            int[][] dir = { 
                {i+1,j},
                {i-1,j},
                {i,j+1},
                {i,j-1}
            };
            for(int[] adj : dir){
               int r = adj[0];
               int c = adj[1];

               if(r<0||c<0||r>=m||c>=n||grid[r][c]==2||grid[r][c]==0) continue;

               grid[r][c] = 2;
               q.add(new int[]{r,c});
            }
        }
        fresh -= q.size();
        count++;
        if(fresh==0) break;
      }
    if(fresh<=0) return count;
    return -1;
    } 
}
