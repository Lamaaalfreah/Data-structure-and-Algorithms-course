
package graphtraversal;

import java.util.*;

public class GraphTraversal {
// Representation of a directed graph using adjacency list
public static void main(String[] args) {
DiGraph g = new DiGraph(10);
g.addEdge(1, 0);
g.addEdge(0, 2);
g.addEdge(2, 1);
g.addEdge(0, 3);
g.addEdge(1, 4);
g.addEdge(4, 5);
g.addEdge(4, 6);
g.addEdge(4, 7);
g.addEdge(6, 7);
g.addEdge(6, 8);
g.addEdge(8, 9);
g.addEdge(9, 9);
g.printGraph();
System.out.println("Depth First Search visit order: ");
g.DFS(0);
System.out.println();
System.out.println("Breadth First Search visit order: ");
g.BFS(0);
System.out.println();
}
}
class DiGraph {
int V; // Number of Vertices
LinkedList<Integer> adj[]; // adjacency lists
// Constructor
DiGraph(int V) {
this.V = V;
adj = new LinkedList[V];
for (int i = 0; i < adj.length; i++)
adj[i] = new LinkedList<Integer>();
}
// To add an edge to graph
void addEdge(int v, int w) {
adj[v].add(w); // Add w to v’s list.
adj[w].add(v);
}

void DFS(int s) {
boolean[] visited = new boolean[V]; 
for (int i = 0; i < V; i++)
visited[i]=false;

Stack<Integer> stack = new Stack<>();
stack.push(s);
while (!stack.empty()) {
int x = stack.pop();
if (visited[x] == false){
System.out.print(x + " ");
visited[x] = true;
}
for(Integer dest: adj[x]){
    if(visited[dest] == false)
    stack.push(dest);
}}}

void BFS(int s) {
// Write the proper code for BFS
boolean [] visited = new boolean[V];
LinkedList<Integer> queue = new LinkedList<Integer>();
visited[s] = true;
queue.add(s) ;
while (queue.size()!= 0) {
s = queue.poll();
System.out.print(s + " ");
Iterator<Integer> i = adj[s].listIterator(); 
while (i.hasNext()) {
int n = i.next(); 
if (!visited[n]) {
visited[n] = true;
queue.add(n);
}}}}

public void printGraph() {
for (int src = 0; src < adj.length; src++) {
System.out.print(src);
for (Integer dest : adj[src]) {
System.out.print(" -> " + dest);
}
System.out.println();
}
}
}