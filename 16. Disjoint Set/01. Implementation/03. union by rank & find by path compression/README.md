## union by rank & find by path-compression
We optimize find function by compressing the path, i.e. we set parent of each node in the path to representative of it's parent. Traversal path length is reduced by 1.

## time complexity
  - For m operations on n elements :
      - time complexity = O(m α(n)), where (α(n) is [inverse ackermann function](https://en.wikipedia.org/wiki/Ackermann_function#Inverse), α(n) < 5)
