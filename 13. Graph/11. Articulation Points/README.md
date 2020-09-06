# Articulation Points
  - An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). 
  - Articulation points represent vulnerabilities in a connected network – single points whose failure would split the network into 2 or more components. They are useful for designing reliable networks.
  
## Algorithm
This algorithm uses a simple observation that and a vertex (u) will be an articulation point, if and only if any one of following two conditions is satisfied by the vertex.
  - vertex u is a root of DFS Tree and has more than one children.
  - vertex u is not the root of DFS Tree and there exist no such descendant vertex (v) from u such that v has a back-edge to one of the ancestors of u in DFS Tree.
  </br></br>
The algorithm described here is based on **depth first search** and has **O(V+E)** time complexity, where **V is the number of vertices** and **E is the number of edges** in the graph.
