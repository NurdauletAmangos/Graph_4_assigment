package graph.util;


import java.util.*;


/**
 * Simple directed graph with optional edge weights and node durations.
 */
public class Graph {
    private final int n;
    private final List<List<Edge>> adj;
    private final long[] nodeDuration; // default 0


    public Graph(int n) {
        this.n = n;
        this.adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        this.nodeDuration = new long[n];
    }


    public int size() { return n; }


    public void addEdge(int u, int v, long w) {
        adj.get(u).add(new Edge(v, w));
    }


    public List<Edge> neighbors(int u) { return Collections.unmodifiableList(adj.get(u)); }


    public void setNodeDuration(int u, long d) { nodeDuration[u] = d; }
    public long getNodeDuration(int u) { return nodeDuration[u]; }


    public static class Edge { public final int to; public final long w; public Edge(int to, long w){this.to=to;this.w=w;} }
}