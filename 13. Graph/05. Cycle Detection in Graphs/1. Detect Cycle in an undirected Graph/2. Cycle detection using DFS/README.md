## Cycle detection using DFS
 - We do a simple DFS traversal of the graph. For all adjacent nodes of current node, if it's unvisited, we call dfs on it, if it's visited already and if it's not parent of current node, we return true.
