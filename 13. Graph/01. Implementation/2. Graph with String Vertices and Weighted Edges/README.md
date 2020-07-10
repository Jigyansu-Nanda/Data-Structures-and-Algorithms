# Graph Implementation (Adjacency List Representation with String Vertices and Weighted Edges)

```java
import java.io.*;
import java.util.*;

class Graph {

	static class Pair
	{
		String v;
		int weight;
		Pair(String v, int weight)
		{
			this.v = v;
			this.weight = weight;
		}
	}

	static void addEdge(HashMap<String, ArrayList<Pair>> graph, String u, String v, int weight, boolean biDirectional) {
		// adding ArrayList, if not present
		if (graph.containsKey(u) == false) {
			graph.put(u, new ArrayList<Pair>());
		}
		// adding Edge
		graph.get(u).add(new Pair(v, weight));

		// if Edge is biDirectional, add the other Edge
		if (biDirectional == true)
		{
			// adding ArrayList, if not present
			if (graph.containsKey(v) == false) {
				graph.put(v, new ArrayList<Pair>());
			}
			// adding Edge
			graph.get(v).add(new Pair(u, weight));
		}
	}

	static void printGraph(HashMap<String, ArrayList<Pair>> graph) {
		for (String u: graph.keySet()) {
			for (Pair p: graph.get(u)) {
				System.out.print(p.v+","+p.weight+"  ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int t = Integer.parseInt(br.readLine());
		while (t > 0)
		{
			// e = number of edges
			int e = Integer.parseInt(br.readLine());
			HashMap<String, ArrayList<Pair>> graph = new HashMap<String, ArrayList<Pair>>();
			for (int i=0; i<e; i++)
			{
				String[] lines = br.readLine().trim().split(" ");
				String u = lines[0];
				String v = lines[1];
				int weight = Integer.parseInt(lines[2]);
				addEdge(graph, u, v, weight, true);
			}
			printGraph(graph);
			t -= 1;
		}
	}
}
```

## input
```
1
5
A B 5
B D 20
B C 3
C D 2
A C 10
```

## output
```
B,5  C,10  
A,5  D,20  C,3  
B,3  D,2  A,10  
B,20  C,2
```
