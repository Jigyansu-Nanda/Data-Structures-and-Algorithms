# Dijkstra's Shortest Path Algorithm
**Given a graph, and a source vertex, find shortest distances from source to all other vertices.**

### pros
 - works for
    - cyclic & acyclic
    - weighted & non-weighted
    - directed & undirected
 
### cons
 - does not work for negative weighted edges.
 
## Idea behind the Algorithm
 - We maintain an Array of distance for all vertices initialized with values Infinite.
 - distance of source is 0
 - At each iteration, we pick a vertex and finalize it distance. Initially no vertex is finalized.
 - *How do we pick the vertex ?*
    - we pick the vertex from the set, which has minimum distance
 - then we go to all adjacent vertices of it, and check whether do we get a shorter path to that vertex, through current vertex, If yes. then we update it's distance
 
## pseudo code
```
   Dijkstra(graph, s):
       Create an empty Priority Queue (Min Heap), pq
       Intialize distance[v] = {INF, INF, INF, INF, INF,........}
       distance[s] = 0
       Insert all distance to Priority Queue pq                           // O(V) time
       while pq is not empty:                                             // loop runs V times
             u = pq.extractMin( )                                         // O(log V) time, overall time O(Vlog V) time
             for (all v: adjacent of u):
                   if (distance[v] > distance[u] + weight(u, v)):
                         distance[v] = distance[u] + weight(u, v)         // overall time O(Elog V)
                                  
                                                                          // overall Time Complexity: O(Vlog V + Elog V)
```
