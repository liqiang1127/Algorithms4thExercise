package Chapter1_5High;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionCompressPath {
    // 1.5.12
    private int[] parent;
    private int count;

    public QuickUnionCompressPath(int N){
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        count = N;
    }

    // anther version of compression path
    private int find(int p){
        int root = p;
        //find the root
        while( root != parent[root])
            root = parent[root];

        //compression path
        while ( p != parent[p]){
            // pp means p's parent
            int pp = parent[p];
            parent[p] = root;
            p = pp;
        }
        return root;
    }

    public void union(int p, int q){
        //Quick Union
        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
        count--;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }


    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionCompressPath uf = new QuickUnionCompressPath(N);
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
