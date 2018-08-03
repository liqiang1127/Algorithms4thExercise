package Chapter1_5High;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SizeCompressPathUF {
    private int[] parent;
    private int[] size;
    private int count;


    public SizeCompressPathUF(int N){
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = N;
    }


    private int find(int p){
        // compress path
        while ( p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        if (size[p] < size[q]){
            parent[p] = q;
            size[q] += size[p];
        }else{
            parent[q] = p;
            size[p] += size[q];
        }
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        SizeCompressPathUF uf = new SizeCompressPathUF(N);
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
