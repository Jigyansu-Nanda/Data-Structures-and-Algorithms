# Disjoint Set
A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.

## Union-Find algorithm
Algorithm to perform two operations on disjoint set data structure
  - **union (x, y)** : Join subset containing x and subset containing y into a single subset
  - **find (x)** : Find the representative element of the subset containg x. We use one element of the subset as a representative element, that represents the corresponding subset.
  
## Implementation
  - Naive implementation
  - union by Rank
  - union by Rank & Find by Path-compression
