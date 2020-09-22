# Strongly Connected Components
A strongly connected components of a directed graph is a subgraph such that all the vertices in that component are reachable from one another. Example:
```
1 -----> 2 ------> 5
∧        |         |
|        ∨         ∨
4 <----- 3         6

There are 3 SCCs in the above graph
First: 1, 2, 3, 4
Second: 5
Third: 6
```

## Algorithms for finding SCCs
  - Kosaraju's Algorithm
  - Tarjan's Algorithm
