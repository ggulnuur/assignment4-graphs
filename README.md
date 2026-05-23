# Assignment 4 — Graph Traversal and Representation System

---

# Project Overview

This project demonstrates graph representation using an adjacency list in Java.

A graph consists of:

- Vertices (nodes)
- Edges (connections between nodes)

The project implements two graph traversal algorithms:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The system also measures traversal performance using `System.nanoTime()`.

---

# Graph Structure

The graph is represented using an adjacency list.

Example:

```text
0 -> 1 5
1 -> 0 2
2 -> 1 3
```

This means:
- Vertex `0` is connected to `1` and `5`
- Vertex `1` is connected to `0` and `2`

Adjacency lists are memory efficient and suitable for sparse graphs.

---

# Class Descriptions

## Vertex Class

Represents a graph vertex.

### Fields
- `id`

### Methods
- Constructor
- `getId()`
- `toString()`

---

## Edge Class

Represents a connection between two vertices.

### Fields
- `source`
- `destination`

### Methods
- Constructor
- Getters
- `toString()`

---

## Graph Class

Represents the graph using an adjacency list.

### Main Methods

| Method | Description |
|---|---|
| `addVertex()` | Adds a new vertex |
| `addEdge()` | Adds connection between vertices |
| `printGraph()` | Prints adjacency list |
| `bfs()` | Performs Breadth-First Search |
| `dfs()` | Performs Depth-First Search |

---

# Adjacency List Representation

The adjacency list stores neighbors for every vertex.

Example:

```text
0 -> 1 2
1 -> 0 3
2 -> 0 4
```

Advantages:
- Memory efficient
- Fast neighbor traversal
- Easy edge insertion

---

# BFS Algorithm

## Breadth-First Search (BFS)

BFS explores the graph level by level.

### Step-by-Step Explanation

1. Start from the source vertex
2. Mark vertex as visited
3. Add vertex to queue
4. Remove vertex from queue
5. Visit all unvisited neighbors
6. Repeat until queue becomes empty

### Use Cases

- Shortest path search
- Social network analysis
- Web crawling
- GPS navigation systems

### Time Complexity

`O(V + E)`

Where:
- `V` = number of vertices
- `E` = number of edges

---

# DFS Algorithm

## Depth-First Search (DFS)

DFS explores as deeply as possible before backtracking.

### Step-by-Step Explanation

1. Start from source vertex
2. Visit one neighbor
3. Continue recursively
4. Backtrack when no neighbors remain
5. Repeat until all vertices are visited

### Use Cases

- Path finding
- Cycle detection
- Topological sorting
- Maze solving

### Time Complexity

`O(V + E)`

Where:
- `V` = number of vertices
- `E` = number of edges

---

# Experimental Results

## Execution Time Comparison

| Graph Size | BFS Time (ns) | DFS Time (ns) |
|------------|---------------|---------------|
| 10 Vertices | 909542 | 147792 |
| 30 Vertices | 239167 | 248000 |
| 100 Vertices | 3285042 | 638708 |

---

# Observations and Patterns

- Traversal time increases as graph size increases.
- BFS became slower on larger graphs because queue operations require additional processing.
- DFS performed faster on the 100-vertex graph.
- Both algorithms follow the expected time complexity `O(V + E)`.

---

# Screenshots

## Graph Structure Output

![Graph Output](docs/screenshots/graph-output.png)
---
## BFS Traversal Output

![BFS Output](docs/screenshots/bfs-output.png)

---

## DFS Traversal Output

![DFS Output](docs/screenshots/dfs-output.png)

---

## Performance Results

![Performance](docs/screenshots/performance.png)

---

# Reflection

This assignment helped me understand how graphs are represented using adjacency lists and how graph traversal algorithms work internally.

I learned the differences between Breadth-First Search and Depth-First Search, including their traversal strategies and performance behavior on different graph sizes. BFS explores vertices level by level using a queue, while DFS explores deeply using recursion.

The most challenging part of the implementation was correctly managing visited vertices and implementing traversal logic without revisiting nodes. Another challenge was testing the algorithms on different graph sizes and comparing their execution times accurately.

Overall, this project improved my understanding of graph data structures, recursion, queues, and algorithm complexity analysis.

---

# Bonus Task – Dijkstra’s Algorithm

## Overview
As a bonus task, Dijkstra’s Algorithm was implemented to find the shortest path from a starting vertex to all other vertices in the graph.

## Requirements Completed
- Added support for weighted edges
- Modified the Edge class by adding a weight field
- Updated graph structure to store weighted edges
- Implemented `void dijkstra(int start)` method

## Edge Class Example

```java
class Edge {
    Vertex destination;
    int weight;

    public Edge(Vertex destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
```

## Dijkstra Algorithm

```java
public void dijkstra(int start) {
    int[] distance = new int[vertices];
    boolean[] visited = new boolean[vertices];

    Arrays.fill(distance, Integer.MAX_VALUE);
    distance[start] = 0;

    for (int i = 0; i < vertices - 1; i++) {

        int min = Integer.MAX_VALUE;
        int u = -1;

        for (int j = 0; j < vertices; j++) {
            if (!visited[j] && distance[j] < min) {
                min = distance[j];
                u = j;
            }
        }

        visited[u] = true;

        for (Edge edge : adjacencyList[u]) {
            int v = edge.destination.id;

            if (!visited[v] &&
                distance[u] != Integer.MAX_VALUE &&
                distance[u] + edge.weight < distance[v]) {

                distance[v] = distance[u] + edge.weight;
            }
        }
    }

    System.out.println("Shortest distances from vertex " + start + ":");

    for (int i = 0; i < vertices; i++) {
        System.out.println("To vertex " + i + " = " + distance[i]);
    }
}
```

## Functionality
The algorithm:
- Takes a starting vertex
- Computes shortest paths to all vertices
- Outputs the shortest distances clearly

## Data Structure
The implementation uses:
- Weighted adjacency list
- Arrays for distances
- Arrays for visited vertices
- Simple loops without priority queue

## Example Output

```text
Shortest distances from vertex 0:
To vertex 1 = 4
To vertex 2 = 7
To vertex 3 = 9
```


