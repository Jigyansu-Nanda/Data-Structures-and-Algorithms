# Kruskal's Minimum Spanning Tree (using Disjoint Set)


#### This is a simpler version of MST problem. We only output the total weight of MST.

## Idea behind the algorithm
  1. Sort all the edges in increasing order of their weights
  2. Initialize: ** MST = { } , MSTweight = 0**
  3. For every edge E:
      - while (MST size is less than V-1):
          - if (adding E to MST does not cause a cycle):
              - MST = MST ∪ E
              - MSTweight += E.weight
  4. return MSTweight
