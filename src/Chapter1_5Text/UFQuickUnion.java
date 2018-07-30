package Chapter1_5Text;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFQuickUnion {
    private int[] id;
    private int count;

    public UFQuickUnion(int N){
        id = new int[N];
        count = N;
    }

    //root is itself
    private int find(int p){
        while( p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;
        id[pRoot] =  qRoot;
//        id[qRoot] = pRoot;
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
        UFQuickUnion uf = new UFQuickUnion(N);
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
