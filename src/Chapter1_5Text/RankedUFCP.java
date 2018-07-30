package Chapter1_5Text;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RankedUFCP {
    private int[] parent;
    // the rank of tree which root is index
    private int[] rank;
    private int count;

    public RankedUFCP(int N){
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        count = N;
    }

    private int find(int p){
        //  compress path
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

        // base on rank
        // append to larger rank tree
        if(rank[qRoot] < rank[pRoot]){
            //append to p-tree
            parent[qRoot] = pRoot;
            //don`t modify rank
        } else if(rank[pRoot] < rank[qRoot]){
            // append to q-tree
            parent[pRoot] = qRoot;
        }else {
            // equal
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
        count --;

    }


    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        RankedUFCP uf = new RankedUFCP(N);
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
