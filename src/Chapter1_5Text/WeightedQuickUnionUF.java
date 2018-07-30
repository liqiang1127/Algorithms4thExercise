package Chapter1_5Text;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
    //optimized on size
    private int[] id;
    // size of the tree which root is index
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        for (int i=0; i<N; i++){
            id[i] = i;
            sz[i] = 1;
        }
        count = N;
    }

    private int find(int p){
        while ( p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);

        if(i == j)
            return;

        if(sz[i] < sz[j]){
            //append to larger tree
            //append to j-tree
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
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
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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
