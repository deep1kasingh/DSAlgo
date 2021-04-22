package leetcode.importantAndUsefulLinks.garph;

public class ClosedIslands {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = m==0? 0:grid[0].length;
        if(m==0 || n==0) return 0;
        boolean [][] markVisited = new boolean[m][n];
        int closedIslands = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 && !markVisited[i][j]){
                    boolean isClosed = true;
                    isClosed = DFS(grid, markVisited, i, j, m, n, isClosed);
                    if(isClosed){
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }

    private boolean DFS(int[][] grid, boolean[][] markVisited, int x, int y, int m, int n, boolean isClosed){
        if(x <0 || y<0 || x>=m || y>=n || grid[x][y]==1 || markVisited[x][y]){
            return true;
        }
        else {
            markVisited[x][y]=true;
            isClosed = isClosedCheck(x,y,m,n);
            for(int i=0;i<4;i++){
                isClosed = DFS(grid, markVisited, x + dirs[i][0], y + dirs[i][1], m, n, isClosed) && isClosed;
            }
            return isClosed;
        }
    }

    private boolean isClosedCheck(int x, int y, int m, int n){
        return x != 0 && x != m-1 && y !=0 && y != n-1;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int ii = new ClosedIslands().closedIsland(input);
        System.out.println(ii);
    }
}
