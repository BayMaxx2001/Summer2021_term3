package csd_q3_sample;

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) //do not edit this function
    {
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("graph.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }

    void fvisitDeg(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i] + "(" + deg[i] + ")");
    }

    void fdispAdj(RandomAccessFile f) throws Exception {
        int i, j;
        f.writeBytes("n = " + n + "\r\n");
        for (i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for (j = 0; j < n; j++) {
                f.writeBytes("  " + a[i][j]);
            }
        }
        f.writeBytes("\r\n");
    }

    void fbreadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        MyQueue q = new MyQueue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void fbreadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        fbreadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                fbreadth(en, i, f);
            }
        }
    }

    void fdepth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                fdepth(visited, i, f);
            }
        }
    }

    void fdepth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        fdepth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                fdepth(visited, i, f);
            }
        }

    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//=================================================================
    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }

    void fbreadth_f1(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        fbreadth_f1(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                fbreadth_f1(en, i, f);

            }
        }
    }

    void fbreadth_f1(boolean[] en, int i, RandomAccessFile f) throws Exception {
        MyQueue q = new MyQueue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            deg[r] = deg(r);
            fvisitDeg(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void f1() throws Exception {
        loadData(10);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        fbreadth(0, f123);// fbreadth first traverse from the vertex 0 (A)
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        fbreadth_f1(0, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
    void fdepth_f2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        fdepth_f2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                fdepth_f2(visited, i, f);
            }
        }

    }

    void fdepth_f2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        deg[k] = deg(k);
        fvisitDeg(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                fdepth_f2(visited, i, f);
            }
        }
    }

    void f2() throws Exception {
        loadData(10);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        fdepth(0, f123);// fdepth first traverse from the vertex 0 (A)
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        fdepth_f2(0, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
    public int connectedParts() { //f123.writeBytes("k = " + k + "\r\n");
        boolean[] pushed = new boolean[20];
        boolean cont = false;
        int i, j, k, r;
        for (i = 0; i < n; i++) {
            pushed[i] = false;
        }
        MyStack s = new MyStack();
        k = 0;
        while (true) {
            s.clear();
            i = 0;
            while (i < n && pushed[i]) {
                i++;
            }
            if (i == n) {
                break;
            }
            s.push(i);
            pushed[i] = true;
            while (!s.isEmpty()) {
                r = s.pop();
                for (i = 0; i < n; i++) {
                    if (i == r) {
                        continue;
                    }
                    if (!pushed[i] && a[r][i] > 0) {
                        s.push(i);
                        pushed[i] = true;
                    }
                }
            }
            k++;
        }

        return (k);
    }

    void f3() throws Exception {
        loadData(21);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        fdispAdj(f123);
        f123.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int k = connectedParts();
        f123.writeBytes("k = " + k + "\r\n");
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
    void dijkstra(int fro, int to, RandomAccessFile f) throws IOException {
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int INF = 999;
        int i, j, k, t;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        S[fro] = true;
        while (true) {
            // find d[k] = min {d[i}}
            t = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    t = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                return;
            }
            // add k to S
            S[k] = true;
            if (k == to) {
                break;
            }
            // update d[i] & p[i]
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
//    System.out.println("The shortest distance is " + d[to]);
        i = to;
        MyStack s = new MyStack();//store vertex
        ArrayList points = new ArrayList();//store distance
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
//print line 1: vertex, line2 : distance

        while (!s.isEmpty()) {
            i = s.pop();
            points.add(i);
        }

//print (0)A->(9)C->(2)F->(9)E
        for (int l = 0; l < points.size() - 1; l++) {
            f.writeBytes("(" + d[(int) points.get(l)] + ")" + v[l] + " " + "->");
        }
        f.writeBytes("(" + d[(int) points.get(points.size() - 1)] + ")" + v[points.size() - 1] + " ");
        f.writeBytes("\n");
    }

    void f4() throws Exception {
        loadData(33);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        dijkstra(0, 5, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
      boolean isUndirected() // The adjacency matrix should be symmetric
  {
    int i, j;
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        if (a[i][j] != a[j][i])
          return (false);
    return (true);
  }

  boolean isEvenDegree() {
    int i, j, deg;
    for (i = 0; i < n; i++) {
      deg = 0;
      for (j = 0; j < n; j++)
        deg += a[i][j];
      if (deg % 2 == 1)
        return (false);
    }
    return (true);
  }

  boolean isConnected() {
    boolean[] pushed = new boolean[20];
    boolean cont = false;
    int i, j, k, r;
    for (i = 0; i < n; i++)
      pushed[i] = false;
    MyStack s = new MyStack();
    s.push(0);
    pushed[0] = true;
    while (!s.isEmpty()) {
      r = s.pop();
      for (i = 0; i < n; i++) {
        if (i == r)
          continue;
        if (!pushed[i] && a[r][i] > 0) {
          s.push(i);
          pushed[i] = true;
        }
      }
    }
    for (i = 0; i < n; i++)
      if (!pushed[i])
        return (false);
    return (true);
  }

  void checkEulerCycle(RandomAccessFile f) throws Exception {
    if (isUndirected())
      f.writeBytes("The graph is undirected.\r\n");
    else
      f.writeBytes("The graph is directed.\r\n");
    if (isConnected())
      f.writeBytes("The graph is connected.\r\n");
    else
      f.writeBytes("The graph is not connected.\r\n");

    if (isEvenDegree())
      f.writeBytes("All vertices have even degree.\r\n");
    else
      f.writeBytes("The graph has a vertex with odd degree\r\n");
    if (isUndirected() && isConnected() && isEvenDegree())
      f.writeBytes("Conditions for Euler's cycle are satisfied.\r\n");
    else
      f.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");

  }

    void f5() throws Exception {//You do not need to edit this file
        //Your task is to complete the checkEulerCycle(...) function above only
        loadData(42);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");

        checkEulerCycle(f123);
        loadData(49);
        f123.writeBytes("\r\n");
        checkEulerCycle(f123);
        
        f123.writeBytes("\r\n");
        f123.close();
    }

//=================================================================
    boolean hasEulerCycle() {
    boolean ok = true;
    if (!isUndirected()) {
      System.out.println("The graph is directed.\r\n");
      ok = false;
    }
    if (!isConnected()) {
      System.out.println("The graph is not connected.\r\n");
      ok = false;
    }

    if (!isEvenDegree()) {
      System.out.println("The graph has a vertex with odd degree\r\n");
      ok = false;
    }
    if (!ok) {
      System.out.println("Conditions for Euler's cycle are not satisfied.\r\n");
      return (false);
    }
    return (true);
  }

  void EulerCycle(int k, RandomAccessFile f) throws Exception {
    if (!hasEulerCycle())
      return;
    MyStack s = new MyStack();
    int[][] b = new int[20][20];
    int[] eu = new int[20];
    int m;
    int i, j, r, t;
    int[] x = new int[50];
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        b[i][j] = a[i][j];
    s.push(k);// Dua dinh k vao Stack
    m = 0;// Ban dau chu trinh chua co phan tu nao
    t = 0;
    x[0] = k;
    while (!s.isEmpty()) {
      r = s.top();
      i = 0;
      while (i < n && b[r][i] == 0)
        i++;// Tim i dau tien de b[r][i]#0
      if (i == n) // r da la dinh co lap, dua r vao chu trinh Euler
      {
        eu[m++] = r;
        s.pop();
      } // Lay dinh co lap ra khoi Stack
      else {
        x[++t] = i;
        s.push(i);
        b[r][i]--;
        b[i][r]--;
      } // Loai canh (i,r) khoi do thi
    }
    for (i = 0; i < m; i++)
      f.writeBytes(v[eu[i]] + "  ");
    f.writeBytes("\r\n");
  }
    
    void f6() throws Exception {
        loadData(42);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f123 = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        EulerCycle(0, f123);
        //-------------------------------------------------------------------------------------
        f123.writeBytes("\r\n");
        f123.close();
    }

}
//=================================================================
