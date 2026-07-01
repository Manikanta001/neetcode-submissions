class Solution {
    int row;
    int col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
            return count;
    }
    void dfs(int i,int j,char[][] grid){
        if(i<0||j<0||i>=row||j>=col||grid[i][j]=='0') return;

        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}
