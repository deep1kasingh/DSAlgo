package datastructures.unionfind.impl;

public class UnionFind {
    //no of elements in this Union Find
    private int size;

    private int[] compSize; //size of each component

    private int[] id; //stores the parent of each i

    private int numOfComponents;

    public UnionFind(int size) throws Exception {
        if (size < 0) {
            throw new Exception("Size cannot be less than 0");
        }
        this.size = this.numOfComponents = size;
        this.compSize = new int[size];
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            this.compSize[i] = 1;
        }
        for(int i=0;i<size;i++){
            this.id[i] = i;
        }
    }

    // finds which subset p belongs to
    private int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        //path compression for amortized time complexity
        while (id[p] != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        if (isConnected(p, q)) return;
        int root1 = find(p);
        int root2 = find(q);
        if (compSize[root1] > compSize[root2]) {
            compSize[root1] += compSize[root2];
            id[root2] = root1;
        } else {
            compSize[root2] += compSize[root1];
            id[root1] = root2;
        }
        numOfComponents--;
    }

    public int getNumOfComponents() {
        return numOfComponents;
    }

    public int size() {
        return size;
    }

    public void printAll() {
        for(int i=0;i<this.size;i++){
            System.out.print(this.id[i]);
            System.out.print(" ");
        }
    }
}
