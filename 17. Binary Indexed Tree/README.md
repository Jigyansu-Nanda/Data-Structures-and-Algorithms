# Binary Indexed Tree / Fenwick Tree
- BIT is used for fixed-size input array and multiple queries of following types.
    - Prefix Operations (Sum, Product, XOR, OR etc..): *O(log n) for each query*
    - Update a value: *O(log n) for each query*
- It is internally represented as an array.
- It requires **O(n log n) preprocessing time** and **θ(n) auxiliary space**.
- It is also known as **Fenwick Tree**.
  
## Implementation
  - The basic idea behind BIT is that every number can be represented as sum of powers of 2.
  - for any prefix query till range i:
    - prefixOpQuery(i) performs prefix operation till index i (total i+1 elements)
    - We can divide these (i+1) elements in different ranges, that are all powers of 2.
  - A fenwick tree can support the following range operations in logarithmic time:
    - **Point Update & Range Query**
    - **Range Update & Point Query**
    - **Range Update & Range Query**
    
## Prefix Sum Implementation
