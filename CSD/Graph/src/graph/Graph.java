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
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Traversal g = new Traversal();
        g.BFS(1);//A
        System.out.println("");
        
        g.DFS(1);
        System.out.println("");

        Dijkstra d = new Dijkstra();
        d.ijk(0, 5);//A->F
    }

}
