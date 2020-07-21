# Prim's Minimum Spanning Tree Algorithm
  - Prim's MST algorithm is greedy algorithm
  - We maintain two sets of vertices
    1. vertices, that are already included in MST (initially empty)
    2. vertices, that are not yet included in MST (initially contains all the vertices)
  - At every step, we consider all the edges, that connect two sets, and pick the minimum weighted edge, then add the vertice at the other end of this edge to MST (set-1)
 
 ## Pseudo code
 

## sample input
```
                              A
                          8 /   \ 9
                            B    C
                        10 / \3  / 5
                          D -- E
                            6
```
