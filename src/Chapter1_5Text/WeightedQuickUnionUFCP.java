package Chapter1_5Text;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUFCP {
    //weighted quick union union-find with compress path
    private int[] parent;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUFCP(int N){
        parent = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
        count = N;
    }

    private int find(int p){
        //compress path
        while (p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }


    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot)
            return;

        // base on size
        // append to larger tree
        if(sz[pRoot] < sz[qRoot]){
            //append to q-tree
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            parent[qRoot] = pRoot;
            sz[pRoot] = sz[qRoot];
        }
        count --;
    }


    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUFCP uf = new WeightedQuickUnionUFCP(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
