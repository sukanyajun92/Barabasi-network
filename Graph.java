import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;


public class Graph {
    
    private TreeMap<Node, ArrayList<Node>> map;

    // number of edges
    private int E;

   /**
     * Create an empty graph with no vertices or edges.
     */
    public Graph() {
    	map = new TreeMap<Node, ArrayList<Node>>();       
    }

   /**
     * Create an graph from given input stream using given delimiter.
     */
   /* public Graph(In in, String delimiter) {
        st = new ST<String, SET<String>>();
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }*/

   /**
     * Number of vertices.
     */
    public int numVertices() {
        return map.size();
    }

   /**
     * Number of edges.
     */
    public int E() {
        return E;
    }

   /**
     * Degree of this vertex.
     */
    public int degree(Node n) {
        if (!map.containsKey(n)) 
        	throw new RuntimeException(n + " is not a vertex");
        else 
        	return map.get(n).size();
    }

   /**
     * Add edge v-w to this graph (if it is not already an edge)
     */
    /*public void addEdge(String v, String w) {
        if (!hasEdge(v, w)) E++;
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        st.get(v).add(w);
        st.get(w).add(v);
    }*/

   /**
     * Add Node n to this graph (if it is not already a vertex)
     */
    public void addVertex(Node n) {
        if (!hasVertex(n))
        	map.put(n, new ArrayList<Node>());
    }


   /**
     * Return the set of nodes.
     */
    public Set<Node> vertices() {
        return map.keySet();
    }

   /**
     * Return the set of neighbors of vertex v as in Iterable.
     */
    public Iterable<Node> adjacentTo(Node n) {
        // return empty set if vertex isn't in graph
        if (!hasVertex(n)) 
        	return new ArrayList<Node>();
        else    
           return map.get(n);
    }

   /**
     * Is v a vertex in this graph?
     */
    public boolean hasVertex(Node n) {
        return map.containsKey(n);
    }

   /**
     * Is v-w an edge in this graph?
     */
    public boolean hasEdge(Node n1, Node n2) {
        if (!hasVertex(n1)) return false;
        return map.get(n1).contains(n2);
    }

   /**
     * Return a string representation of the graph.
     */
   /* public String toString() {
        String s = "";
        for (String v : st) {
            s += v + ": ";
            for (String w : st.get(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        G.addEdge("A", "B");
        G.addEdge("A", "C");
        G.addEdge("C", "D");
        G.addEdge("D", "E");
        G.addEdge("D", "G");
        G.addEdge("E", "G");
        G.addVertex("H");

        // print out graph
        StdOut.println(G);

        // print out graph again by iterating over vertices and edges
        for (String v : G.vertices()) {
            StdOut.print(v + ": ");
            for (String w : G.adjacentTo(v)) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        }

    }*/

}
