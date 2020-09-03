## Cycle detection using BFS
  - We do a BFS traversal of the given graph. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph. If we don’t find such an adjacent for any vertex, we say that there is no cycle. 
  - The assumption of this approach is that there are no parallel edges between any two vertices.
  - We use a parent array to keep track of parent vertex for a vertex so that we do not consider visited parent as cycle.
