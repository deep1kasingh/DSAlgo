package datastructures.unionfind.impl;

public class UnionFindTest {
    public static void main(String[] args) throws Exception {
        UnionFind unionFind = new UnionFind(8);

        unionFind.union(0,1);
        unionFind.union(2,3);
        unionFind.union(4,5);
        unionFind.union(6,7);
        unionFind.union(0,4);

        System.out.println(unionFind.getNumOfComponents());
        unionFind.printAll();
    }
}
