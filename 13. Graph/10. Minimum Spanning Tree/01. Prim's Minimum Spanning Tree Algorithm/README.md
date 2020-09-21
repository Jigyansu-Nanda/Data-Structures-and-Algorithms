# Prim's Minimum Spanning Tree Algorithm
  - Prim's MST algorithm is a greedy algorithm
  - In this algorithm, we maintain two sets of vertices
    1. vertices, that are already included in MST (initially empty)
    2. vertices, that are not yet included in MST (initially contains all the vertices)
  - At every step, we consider all the edges, that connect two sets, and pick the minimum weighted edge, then add the vertice at the other end of this edge to MST (set-1)

#### Input
```
                              0
                          8 /   \ 9
                            1    2
                        10 / \3  / 5
                          3 - 4
                            6
```

#### Output
```
                              0
                          8 /
                            1
                              \ 3
                               4
                           6 /   \ 5
                            3     2
```

#### Implementation Pseudo Code
```
  
```
