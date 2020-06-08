package datastructures.unionfind.impl;

public class NoOfIslandsTest {
    public static void main(String[] args) {
//        char[][] grid = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };
        char[][] grid = new char[][]{
                {'1'},{'1'}
        };
        int noOfComponents = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(grid[i][j] == '1'){
                    noOfComponents++;
                }
            }
        }
        UnionFind unionFind = new UnionFind(rowLen * colLen, noOfComponents);
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(grid[i][j]=='1'){
                    if(i+1 < rowLen && grid[i+1][j] == '1'){
                        unionFind.union(i*colLen + j, (i+1)*colLen+j);
                    }
                    if(j+1 < colLen && grid[i][j+1] == '1'){
                        unionFind.union(i*colLen + j, i*colLen+j+1);
                    }
                }
            }
        }
        System.out.println(unionFind.noOfComponents);
    }

    private static class UnionFind {
        int size;
        int compSz[];
        int id[];
        int noOfComponents;

        UnionFind(int size, int noOfComponents){
            this.size = size;
            this.noOfComponents = noOfComponents;
            this.id = new int[this.size];
            this.compSz = new int[this.size];
            for(int i=0;i<this.size;i++){
                id[i] = i;
                compSz[i]=1;
            }
        }

        private int find(int p){
            int root = p;
            while(root != id[root]){
                root = id[root];
            }

            while(id[p] != root){
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }

        public void union(int p, int q){
            if(find(p) == find(q)) return;
            int root1 = find(p);
            int root2 = find(q);
            if(compSz[root1]>compSz[root2]){
                compSz[root1] += compSz[root2];
                id[root2] = root1;
            } else {
                compSz[root2] += compSz[root1];
                id[root1] = root2;
            }
            noOfComponents--;
        }

        public int getNoOfComponents(){
            return noOfComponents;
        }
    }
}
