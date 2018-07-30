package Chapter1_5Low;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionShowID {
    private int[] parent;
    private int count;

    public QuickUnionShowID(int N){
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        count = N;
    }

    private int find(int p){
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    private void printArr(int[] arr){
        StdOut.print("id: ");
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i]+ " ");
        }
        StdOut.println();
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            printArr(parent);
            return;
        }

        parent[qRoot] = pRoot;
        count--;
        printArr(parent);
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int  count(){
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionShowID uf = new QuickUnionShowID(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p, q);
//            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
