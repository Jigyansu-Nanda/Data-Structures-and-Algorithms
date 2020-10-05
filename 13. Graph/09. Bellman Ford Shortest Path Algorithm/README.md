# Bellman Ford Shortest Path Algorithm
Bellman Ford shortest path algorithm is a dynamic programming based algorithm that computes from source node all reachable nodes. This algorithm was proposed by Alfonso Shimbel and was named after it's publishers Richard Bellman and Lester Ford Jr. .Even though this algorithm is relatively slower than Dijkstra's algorithm, it has one major advantage that, **it can detect negative weighted edge cycles.**

## Idea behind the algorithm
  - The key idea of the algorithm is **If there are V vertices in a graph (that does not contain negative weighted edge cycles), then any existing shortest path, between any source and destination vertex can not have length more than V-1.**
  - We first find out the shortest path containing 1 edge, then shortest path containing 2 edges, then 3 edges and so on..
  
## Pseudo code
```
function BellmanFord(Graph[V], source, destination) {
      1. intialize distance[V] = {INF, INF, INF, INF, INF,........}
      2. distance[source] = 0
      3. for (count 0 to V-1)
              for (every edge u to v)
                   if (distance[v] > distance[u] + weight(u, v))
                        distance[v] = distance[u] + weight(u, v)
```

## Negative weight edge cycle detection
For detection of negative weighted edge cycles, we run one more loop to check whether finalized distances are further reducing or not. If yes,then report negative weighted edge cycle.

```
for (every edge u to v) {
     if (distance[v] > distance[u] + weight(u, v)) {
         report (negative weighted edge cycle exists)
```

## Time Complexity : O(V * E)

## Pros
  - Works for both weighted & unweighted graph
  - Works for both cyclic & acyclic graph
  - Works for both directed & undirected graph
  - Works for negative weight edges
  - Detects negative weight edge cycles, if any
  
## Cons
  - Slower than Dijkstra's algorithm
 
## Implementation
