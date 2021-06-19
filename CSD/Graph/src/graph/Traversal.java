/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author ADMIN
 */
public class Traversal {

    int[][] a;
    int n;
    char[] vertex = "ABCDEFGHIJKLMN".toCharArray();

    public Traversal() {
        int[][] b = {
            //A  B  C  D  E  F  G  H  I
            {0, 1, 1, 1, 0, 0, 0, 0, 0}, //A
            {1, 0, 1, 1, 0, 0, 0, 0, 0}, //B 
            {1, 1, 0, 1, 0, 0, 0, 0, 0}, //C
            {1, 1, 1, 0, 0, 1, 0, 0, 0}, //D
            {0, 0, 0, 0, 0, 1, 0, 0, 0}, //E
            {0, 0, 0, 1, 1, 0, 0, 0, 0}, //F
            {0, 0, 0, 0, 0, 0, 0, 1, 1}, //G
            {0, 0, 0, 0, 0, 0, 1, 0, 0}, //H
            {0, 0, 0, 0, 0, 0, 1, 0, 0} //I
        };
        a = b;
        n = a.length;
    }

    public void visit(int i) {
        System.out.print(vertex[i] + "  ");
    }

    public void BFS(int u, boolean[] c) {
        MyQueue mq = new MyQueue();
        mq.enqueue(u);
        c[u] = true;
        while (!mq.isEmpty()) {
            int j = (int) mq.dequeue();
            visit(j);
            for (int i = 0; i < n; i++) {
                if (!c[i] && a[j][i] > 0) {
                    mq.enqueue(i);
                    c[i] = true;
                }
            }
        }
    }

    public void BFS(int u) {
        boolean[] c = new boolean[n];
        BFS(u, c);
        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                BFS(i, c);
            }
        }
    }

    //Depth first traversal
    public void DFS(int i, boolean[] c) {
        c[i] = true;
        visit(i);
        for (int j = 0; j < n; j++) {
            if (!c[j] && a[i][j] > 0) {
                DFS(j, c);
            }
        }
    }

    public void DFS(int i) {
        boolean[] c = new boolean[n];
        DFS(i, c);
        for (int j = 0; j < n; j++) {
            if (!c[j]) {
                DFS(j, c);
            }
        }
    }
}
