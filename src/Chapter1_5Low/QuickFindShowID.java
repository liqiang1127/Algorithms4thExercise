package Chapter1_5Low;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindShowID {
    // quick find
    private int[] root;
    private int count;

    public QuickFindShowID(int N){
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
        count = N;
    }


    private int find(int p){
        return root[p];
    }

    public void union(int p, int q){
        int proot = find(p);
        int qroot = find(q);

        if( proot == qroot){
            printArr(root);
            return;
        }

        for (int i = 0; i < root.length ; i++) {
            if(root[i] == proot)
                root[i] = qroot;
        }
        count--;
        printArr(root);
    }


    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int count(){
        return count;
    }

    private void printArr(int[] arr){
        StdOut.print("root: ");
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(arr[i]+ " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickFindShowID uf = new QuickFindShowID(N);
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
