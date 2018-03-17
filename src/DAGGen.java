/**
 * @author Dillon Sykes
 * @credits https://algs4.cs.princeton.edu/42digraph/DigraphGenerator.java.html all files
 * and dependencies modeled from here and it respective other .java files.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class creates a DAG or a simple Digraph credits above.
 */
public class DAGGen {
    private static final class Edge implements Comparable<Edge> {
        private final int v;
        private final int w;

        private Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge that) {
            if (this.v < that.v) return -1;
            if (this.v > that.v) return +1;
            if (this.w < that.w) return -1;
            if (this.w > that.w) return +1;
            return 0;
        }
    }


    public DAGGen() {

    }

    /**
     * Returns a random simple digraph containing {@code V} vertices and {@code E} edges.
     * @param V the number of vertices
     * @param E the number of vertices
     * @return a random simple digraph on {@code V} vertices, containing a total
     *     of {@code E} edges
     * @throws IllegalArgumentException if no such simple digraph exists
     */
    public static Digraph simple(int V, int E) {
        if (E > (long) V*(V-1)) throw new IllegalArgumentException("Too many edges");
        if (E < 0)              throw new IllegalArgumentException("Too few edges");
        Digraph G = new Digraph(V);
        SET<Edge> set = new SET<Edge>();
        while (G.E() < E) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            Edge e = new Edge(v, w);
            if ((v != w) && !set.contains(e)) {
                set.add(e);
                G.addEdge(v, w);
            }
        }
        return G;
    }

    /**
     * Returns a random simple DAG containing {@code V} vertices and {@code E} edges.
     * Note: it is not uniformly selected at random among all such DAGs.
     * @param V the number of vertices
     * @param E the number of vertices
     * @return a random simple DAG on {@code V} vertices, containing a total
     *     of {@code E} edges
     * @throws IllegalArgumentException if no such simple DAG exists
     */
    public static Digraph dag(int V, int E) {
        if (E > (long) V*(V-1) / 2) throw new IllegalArgumentException("Too many edges");
        if (E < 0)                  throw new IllegalArgumentException("Too few edges");
        Digraph G = new Digraph(V);
        SET<Edge> set = new SET<Edge>();
        int[] vertices = new int[V];
        for (int i = 0; i < V; i++)
            vertices[i] = i;
        StdRandom.shuffle(vertices);
        while (G.E() < E) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            Edge e = new Edge(v, w);
            if ((v < w) && !set.contains(e)) {
                set.add(e);
                G.addEdge(vertices[v], vertices[w]);
            }
        }
        return G;
    }

    /**
     * Creates a Digrapgh Object that is not a DAG prints to a file then reads that file and inserts values into graph
     * @param numOfVertex the number of vertex you want for your graph
     * @param numOfEdges the number of edges you want for your graph
     * @return will return a Graph Object (See Graph.java)
     */
    public Graph createSimpleGraph(int numOfVertex, int numOfEdges){
        Graph newGraph = new Graph();
        Digraph aD = DAGGen.simple(numOfVertex,numOfEdges);
        File outFile = new File("Simpleout.txt"); //Your file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        System.out.print(aD);
        // pass the path to the file as a parameter
        File inFile =
                new File("Simpleout.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String vertex = Graph.getVertexFromString(line);
            newGraph.verticies.add(vertex);
            String edges = Graph.getEdgesFromString(line);
            char [] tmp = edges.toCharArray();
            ArrayList<String> aTmp = new ArrayList<>();
            for (char c : tmp){
                if(c != (' ')){
                    String s = String.valueOf(c);
                    aTmp.add(s);
                }
            }
            newGraph.edgeList.put(vertex,aTmp);
        }
        return newGraph;
    }
    /**
     * Creates a Digrapgh Object that is a DAG prints to a file then reads that file and inserts values into graph
     * @param numOfVertex the number of vertex you want for your graph
     * @param numOfEdges the number of edges you want for your graph
     * @return will return a Graph Object (See Graph.java)
     */
    public Graph createDAG(int numOfVertex, int numOfEdges){
        Graph newGraph = new Graph();
        Digraph aD = DAGGen.dag(numOfVertex,numOfEdges);
        File outFile = new File("dagOut.txt"); //Your file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
        System.out.print(aD);
        // pass the path to the file as a parameter
        File inFile =
                new File("dagOut.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String vertex = Graph.getVertexFromString(line);
            newGraph.verticies.add(vertex);
            String edges = Graph.getEdgesFromString(line);
            char [] tmp = edges.toCharArray();
            ArrayList<String> aTmp = new ArrayList<>();
            for (char c : tmp){
                if(c != (' ')){
                    String s = String.valueOf(c);
                    aTmp.add(s);
                }
            }
            newGraph.edgeList.put(vertex,aTmp);
        }
        return newGraph;
    }
}
