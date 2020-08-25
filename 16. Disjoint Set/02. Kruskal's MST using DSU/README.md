# Kruskal's Minimum Spanning Tree (using Disjoint Set)
Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A single graph can have many different spanning trees. A **minimum spanning tree (MST)** or minimum weight spanning tree for a weighted, connected and undirected graph is a spanning tree with weight less than or equal to the weight of every other spanning tree. The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.</br></br>
**Number of edges in a minimum spanning tree**: A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.

#### This is a simpler version of MST problem. We only output the total weight of MST.

## Idea behind the algorithm
  1. Sort all the edges in increasing order of their weights
  2. Initialize: **MST = { } , MSTweight = 0**
  3. For every edge E:
      - while (MST size is less than V-1):
          - if (adding E to MST does not cause a cycle):
              - MST = MST ∪ E
              - MSTweight += E.weight
  4. return MSTweight
